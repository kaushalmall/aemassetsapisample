package com.adobe.people.kmall;

import com.adobe.people.kmall.json.pojo.AssetsApiJsonPojo;
import com.adobe.people.kmall.json.pojo.Entity;
import com.adobe.people.kmall.json.pojo.Link;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.apache.commons.httpclient.Credentials;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.io.IOUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.http.HttpHost;
import org.apache.http.HttpStatus;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by kmall on 12/21/17
 *
 *  /**
 *  for each folder entity for in the /api/assets.json
 *  get the folder entities like below
 *  get all the asset entites like below
 *
 *  for each folder entity, do the below recursively until there are no folder
 *  get the folder entities like below
 *  get all the asset entites like below
 *
 *  for all asset entities you can get the Properties object and then the metadata object
 *
 *  I used http://www.jsonschema2pojo.org/
 *  to generate all the classes under com.adobe.people.kmall.json.pojo
 *
 *  You will need to add more details to POJOs like com.adobe.people.kmall.json.pojo.Metadata.
 *
 *  Or you might want to generate JSON schema from JSON on
 *  https://liquid-technologies.com/online-json-to-schema-converter
 *  then use jsonschema2pojo.org
 *
 *  The metadata object is available on the asset entity JSON under the property tag like
 *
 *  http://localhost:4502/api/assets/myfolder/01540_driftwood_1680x1050.jpg.json
 */
public class AemAssetsApiSample {

    private final static String AEM_HOST = "localhost";
    private final static String AEM_PORT = "4502";
    private final static String AEM_USERNAME = "admin";
    private final static String AEM_PASS = "admin";

    private final static String ASSETS_API = "/api/assets.json";

    public static void main(String[] args){

        try {
            HttpHost httpHost = new HttpHost(AEM_HOST, Integer.parseInt(AEM_PORT));
            Credentials credentials = new UsernamePasswordCredentials(AEM_USERNAME, AEM_PASS);

            AssetsApiJsonPojo assetsApiJsonPojo = getAssetsApiJsonPojo( httpHost.toString() + ASSETS_API );

            List<Entity> assetEntities = new ArrayList<Entity>();

            getAssetEntities( assetsApiJsonPojo.getEntities(), assetEntities );

            System.out.println( "Asset Entities Size : " + assetEntities.size() );

            for( Entity assetEntity : assetEntities ){

                List<Link> assetLinks = assetEntity.getLinks();

                for( Link link : assetLinks ){
                    System.out.println( "Asset Href : " + link.getHref() );
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            //do finally stuff here
        }
    }

    private static void getAssetEntities( List<Entity> entities, List<Entity> assetEntities) throws IOException {

        if( entities != null && entities.size() > 0 ){
            for( Entity entity : entities ){
                List<String> entityClasses = entity.getClass_();

                for( String entityClass : entityClasses ){
                    if ("assets/folder".equalsIgnoreCase( entityClass ) ){
                        getAssetEntities(entity, assetEntities);
                    } else if ("assets/asset".equalsIgnoreCase( entityClass ) ){
                        assetEntities.add( entity );
                    }
                }
            }
        }
    }

    private static void getAssetEntities( Entity entity, List<Entity> assetEntities) throws IOException {

        List<Link> entityLinks = entity.getLinks();
        for( Link link : entityLinks ){
            String href = link.getHref();

            AssetsApiJsonPojo assetsApiJsonPojo = getAssetsApiJsonPojo( href );

            getAssetEntities( assetsApiJsonPojo.getEntities(), assetEntities );
        }

    }

    private static AssetsApiJsonPojo getAssetsApiJsonPojo(String href) throws IOException {

        System.out.println( "Getting Details : " + href );

        Credentials credentials = new UsernamePasswordCredentials(AEM_USERNAME, AEM_PASS);

        HttpClient httpClient = new HttpClient();
        httpClient.getParams().setAuthenticationPreemptive(true);
        httpClient.getState().setCredentials(AuthScope.ANY, credentials);

        GetMethod getMethod = new GetMethod( href );
        int statusCode = httpClient.executeMethod( getMethod );

        if (statusCode != HttpStatus.SC_OK) {
            System.err.println("Method failed: " + getMethod.getStatusLine());
        }

        InputStream inputStream = getMethod.getResponseBodyAsStream();

        String responseString = IOUtils.toString(inputStream, "UTF-8");
        if( StringUtils.isNotEmpty( responseString ) ){
            ObjectMapper objectMapper = new ObjectMapper();
            AssetsApiJsonPojo assetsApiJsonPojo = objectMapper.readValue( responseString, AssetsApiJsonPojo.class );

            return assetsApiJsonPojo;
        }

        return null;
    }
}
