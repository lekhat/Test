
package com.microsoft.cisl.generated.wadl.client;

import java.net.URI;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.Generated;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.Response;
import javax.ws.rs.core.UriBuilder;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.uri.UriTemplate;

@Generated(value = {
    "wadl|file:/Users/jahoman/work/webby/src/main/resources/wadl/webhdfs.wadl"
}, comments = "wadl2java, http://wadl.java.net", date = "2014-09-24T15:48:39.901-07:00")
public class Localhost_WebhdfsV1 {

    /**
     * The base URI for the resource represented by this proxy
     * 
     */
    public final static URI BASE_URI;

    static {
        URI originalURI = URI.create("http://localhost:51573/webhdfs/v1/");
        // Look up to see if we have any indirection in the local copy
        // of META-INF/java-rs-catalog.xml file, assuming it will be in the
        // oasis:name:tc:entity:xmlns:xml:catalog namespace or similar duck type
        java.io.InputStream is = Localhost_WebhdfsV1.class.getResourceAsStream("/META-INF/jax-rs-catalog.xml");
        if (is!=null) {
            try {
                // Ignore the namespace in the catalog, can't use wildcard until
                // we are sure we have XPath 2.0
                String found = javax.xml.xpath.XPathFactory.newInstance().newXPath().evaluate(
                    "/*[name(.) = 'catalog']/*[name(.) = 'uri' and @name ='" + originalURI +"']/@uri", 
                    new org.xml.sax.InputSource(is)); 
                if (found!=null && found.length()>0) {
                    originalURI = java.net.URI.create(found);
                }
                
            }
            catch (Exception ex) {
                ex.printStackTrace();
            }
            finally {
                try {
                    is.close();
                } catch (java.io.IOException e) {
                }
            }
        }
        BASE_URI = originalURI;
    }

    public static Localhost_WebhdfsV1 .Index index(com.sun.jersey.api.client.Client client, URI baseURI) {
        return new Localhost_WebhdfsV1 .Index(client, baseURI);
    }

    /**
     * Template method to allow tooling to customize the new Client
     * 
     */
    private static void customizeClientConfiguration(ClientConfig cc) {
    }

    /**
     * Template method to allow tooling to override Client factory
     * 
     */
    private static com.sun.jersey.api.client.Client createClientInstance(ClientConfig cc) {
        return com.sun.jersey.api.client.Client.create(cc);
    }

    /**
     * Create a new Client instance
     * 
     */
    public static com.sun.jersey.api.client.Client createClient() {
        ClientConfig cc = new DefaultClientConfig();
        customizeClientConfiguration(cc);
        return createClientInstance(cc);
    }

    public static Localhost_WebhdfsV1 .Index index() {
        return index(createClient(), BASE_URI);
    }

    public static Localhost_WebhdfsV1 .Index index(com.sun.jersey.api.client.Client client) {
        return index(client, BASE_URI);
    }

    public static class Index {

        private com.sun.jersey.api.client.Client _client;
        private UriBuilder _uriBuilder;
        private Map<String, Object> _templateAndMatrixParameterValues;

        private Index(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
            _client = client;
            _uriBuilder = uriBuilder.clone();
            _templateAndMatrixParameterValues = map;
        }

        /**
         * Create new instance using existing Client instance, and a base URI and any parameters
         * 
         */
        public Index(com.sun.jersey.api.client.Client client, URI baseUri) {
            _client = client;
            _uriBuilder = UriBuilder.fromUri(baseUri);
            _uriBuilder = _uriBuilder.path("");
            _templateAndMatrixParameterValues = new HashMap<String, Object>();
        }

        public<T >T putAsOctetStream(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T putAsOctetStream(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T putAsOctetStream(String delegation, String userName, String doas, String op, String destination, String owner, String group, String permission, String overwrite, String buffersize, String replication, String blocksize, String modificationtime, String accesstime, String renameoptions, String createparent, String token, String aclspec, String xattrName, String xattrValue, String flag, String snapshotname, String oldsnapshotname, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (destination == null) {
            }
            if (destination!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("destination", destination);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("destination", ((Object[]) null));
            }
            if (owner == null) {
            }
            if (owner!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("owner", owner);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("owner", ((Object[]) null));
            }
            if (group == null) {
            }
            if (group!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("group", group);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("group", ((Object[]) null));
            }
            if (permission == null) {
            }
            if (permission!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("permission", permission);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("permission", ((Object[]) null));
            }
            if (overwrite == null) {
            }
            if (overwrite!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", overwrite);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            if (replication == null) {
            }
            if (replication!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("replication", replication);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("replication", ((Object[]) null));
            }
            if (blocksize == null) {
            }
            if (blocksize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", blocksize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", ((Object[]) null));
            }
            if (modificationtime == null) {
            }
            if (modificationtime!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", modificationtime);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", ((Object[]) null));
            }
            if (accesstime == null) {
            }
            if (accesstime!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", accesstime);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", ((Object[]) null));
            }
            if (renameoptions == null) {
            }
            if (renameoptions!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", renameoptions);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", ((Object[]) null));
            }
            if (createparent == null) {
            }
            if (createparent!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("createparent", createparent);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("createparent", ((Object[]) null));
            }
            if (token == null) {
            }
            if (token!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("token", token);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("token", ((Object[]) null));
            }
            if (aclspec == null) {
            }
            if (aclspec!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", aclspec);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", ((Object[]) null));
            }
            if (xattrName == null) {
            }
            if (xattrName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
            }
            if (xattrValue == null) {
            }
            if (xattrValue!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", xattrValue);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", ((Object[]) null));
            }
            if (flag == null) {
            }
            if (flag!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("flag", flag);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("flag", ((Object[]) null));
            }
            if (snapshotname == null) {
            }
            if (snapshotname!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
            }
            if (oldsnapshotname == null) {
            }
            if (oldsnapshotname!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", oldsnapshotname);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T putAsOctetStream(String delegation, String userName, String doas, String op, String destination, String owner, String group, String permission, String overwrite, String buffersize, String replication, String blocksize, String modificationtime, String accesstime, String renameoptions, String createparent, String token, String aclspec, String xattrName, String xattrValue, String flag, String snapshotname, String oldsnapshotname, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (destination == null) {
            }
            if (destination!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("destination", destination);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("destination", ((Object[]) null));
            }
            if (owner == null) {
            }
            if (owner!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("owner", owner);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("owner", ((Object[]) null));
            }
            if (group == null) {
            }
            if (group!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("group", group);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("group", ((Object[]) null));
            }
            if (permission == null) {
            }
            if (permission!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("permission", permission);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("permission", ((Object[]) null));
            }
            if (overwrite == null) {
            }
            if (overwrite!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", overwrite);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            if (replication == null) {
            }
            if (replication!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("replication", replication);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("replication", ((Object[]) null));
            }
            if (blocksize == null) {
            }
            if (blocksize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", blocksize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", ((Object[]) null));
            }
            if (modificationtime == null) {
            }
            if (modificationtime!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", modificationtime);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", ((Object[]) null));
            }
            if (accesstime == null) {
            }
            if (accesstime!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", accesstime);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", ((Object[]) null));
            }
            if (renameoptions == null) {
            }
            if (renameoptions!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", renameoptions);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", ((Object[]) null));
            }
            if (createparent == null) {
            }
            if (createparent!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("createparent", createparent);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("createparent", ((Object[]) null));
            }
            if (token == null) {
            }
            if (token!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("token", token);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("token", ((Object[]) null));
            }
            if (aclspec == null) {
            }
            if (aclspec!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", aclspec);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", ((Object[]) null));
            }
            if (xattrName == null) {
            }
            if (xattrName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
            }
            if (xattrValue == null) {
            }
            if (xattrValue!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", xattrValue);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", ((Object[]) null));
            }
            if (flag == null) {
            }
            if (flag!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("flag", flag);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("flag", ((Object[]) null));
            }
            if (snapshotname == null) {
            }
            if (snapshotname!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
            }
            if (oldsnapshotname == null) {
            }
            if (oldsnapshotname!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", oldsnapshotname);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T putAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T putAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T putAsJson(String delegation, String userName, String doas, String op, String destination, String owner, String group, String permission, String overwrite, String buffersize, String replication, String blocksize, String modificationtime, String accesstime, String renameoptions, String createparent, String token, String aclspec, String xattrName, String xattrValue, String flag, String snapshotname, String oldsnapshotname, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (destination == null) {
            }
            if (destination!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("destination", destination);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("destination", ((Object[]) null));
            }
            if (owner == null) {
            }
            if (owner!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("owner", owner);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("owner", ((Object[]) null));
            }
            if (group == null) {
            }
            if (group!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("group", group);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("group", ((Object[]) null));
            }
            if (permission == null) {
            }
            if (permission!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("permission", permission);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("permission", ((Object[]) null));
            }
            if (overwrite == null) {
            }
            if (overwrite!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", overwrite);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            if (replication == null) {
            }
            if (replication!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("replication", replication);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("replication", ((Object[]) null));
            }
            if (blocksize == null) {
            }
            if (blocksize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", blocksize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", ((Object[]) null));
            }
            if (modificationtime == null) {
            }
            if (modificationtime!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", modificationtime);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", ((Object[]) null));
            }
            if (accesstime == null) {
            }
            if (accesstime!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", accesstime);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", ((Object[]) null));
            }
            if (renameoptions == null) {
            }
            if (renameoptions!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", renameoptions);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", ((Object[]) null));
            }
            if (createparent == null) {
            }
            if (createparent!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("createparent", createparent);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("createparent", ((Object[]) null));
            }
            if (token == null) {
            }
            if (token!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("token", token);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("token", ((Object[]) null));
            }
            if (aclspec == null) {
            }
            if (aclspec!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", aclspec);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", ((Object[]) null));
            }
            if (xattrName == null) {
            }
            if (xattrName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
            }
            if (xattrValue == null) {
            }
            if (xattrValue!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", xattrValue);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", ((Object[]) null));
            }
            if (flag == null) {
            }
            if (flag!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("flag", flag);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("flag", ((Object[]) null));
            }
            if (snapshotname == null) {
            }
            if (snapshotname!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
            }
            if (oldsnapshotname == null) {
            }
            if (oldsnapshotname!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", oldsnapshotname);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T putAsJson(String delegation, String userName, String doas, String op, String destination, String owner, String group, String permission, String overwrite, String buffersize, String replication, String blocksize, String modificationtime, String accesstime, String renameoptions, String createparent, String token, String aclspec, String xattrName, String xattrValue, String flag, String snapshotname, String oldsnapshotname, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (destination == null) {
            }
            if (destination!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("destination", destination);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("destination", ((Object[]) null));
            }
            if (owner == null) {
            }
            if (owner!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("owner", owner);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("owner", ((Object[]) null));
            }
            if (group == null) {
            }
            if (group!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("group", group);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("group", ((Object[]) null));
            }
            if (permission == null) {
            }
            if (permission!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("permission", permission);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("permission", ((Object[]) null));
            }
            if (overwrite == null) {
            }
            if (overwrite!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", overwrite);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            if (replication == null) {
            }
            if (replication!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("replication", replication);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("replication", ((Object[]) null));
            }
            if (blocksize == null) {
            }
            if (blocksize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", blocksize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", ((Object[]) null));
            }
            if (modificationtime == null) {
            }
            if (modificationtime!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", modificationtime);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", ((Object[]) null));
            }
            if (accesstime == null) {
            }
            if (accesstime!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", accesstime);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", ((Object[]) null));
            }
            if (renameoptions == null) {
            }
            if (renameoptions!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", renameoptions);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", ((Object[]) null));
            }
            if (createparent == null) {
            }
            if (createparent!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("createparent", createparent);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("createparent", ((Object[]) null));
            }
            if (token == null) {
            }
            if (token!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("token", token);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("token", ((Object[]) null));
            }
            if (aclspec == null) {
            }
            if (aclspec!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", aclspec);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", ((Object[]) null));
            }
            if (xattrName == null) {
            }
            if (xattrName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
            }
            if (xattrValue == null) {
            }
            if (xattrValue!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", xattrValue);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", ((Object[]) null));
            }
            if (flag == null) {
            }
            if (flag!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("flag", flag);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("flag", ((Object[]) null));
            }
            if (snapshotname == null) {
            }
            if (snapshotname!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
            }
            if (oldsnapshotname == null) {
            }
            if (oldsnapshotname!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", oldsnapshotname);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T postAsOctetStream(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T postAsOctetStream(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T postAsOctetStream(String delegation, String userName, String doas, String op, String sources, String buffersize, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (sources == null) {
            }
            if (sources!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("sources", sources);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("sources", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T postAsOctetStream(String delegation, String userName, String doas, String op, String sources, String buffersize, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (sources == null) {
            }
            if (sources!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("sources", sources);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("sources", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T postAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T postAsJson(String delegation, String userName, String doas, String op, String sources, String buffersize, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (sources == null) {
            }
            if (sources!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("sources", sources);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("sources", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T postAsJson(String delegation, String userName, String doas, String op, String sources, String buffersize, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (sources == null) {
            }
            if (sources!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("sources", sources);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("sources", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T deleteAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T deleteAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T deleteAsJson(String delegation, String userName, String doas, String op, String recursive, String snapshotname, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (recursive == null) {
            }
            if (recursive!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("recursive", recursive);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("recursive", ((Object[]) null));
            }
            if (snapshotname == null) {
            }
            if (snapshotname!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T deleteAsJson(String delegation, String userName, String doas, String op, String recursive, String snapshotname, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (recursive == null) {
            }
            if (recursive!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("recursive", recursive);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("recursive", ((Object[]) null));
            }
            if (snapshotname == null) {
            }
            if (snapshotname!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T getAsOctetStream(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T getAsOctetStream(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T getAsOctetStream(String delegation, String userName, String doas, String op, String offset, String length, String renewer, String buffersize, String xattrName, String encoding, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (offset == null) {
            }
            if (offset!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("offset", offset);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("offset", ((Object[]) null));
            }
            if (length == null) {
            }
            if (length!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("length", length);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("length", ((Object[]) null));
            }
            if (renewer == null) {
            }
            if (renewer!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("renewer", renewer);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("renewer", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            if (xattrName == null) {
            }
            if (xattrName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
            }
            if (encoding == null) {
            }
            if (encoding!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("encoding", encoding);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("encoding", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T getAsOctetStream(String delegation, String userName, String doas, String op, String offset, String length, String renewer, String buffersize, String xattrName, String encoding, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (offset == null) {
            }
            if (offset!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("offset", offset);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("offset", ((Object[]) null));
            }
            if (length == null) {
            }
            if (length!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("length", length);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("length", ((Object[]) null));
            }
            if (renewer == null) {
            }
            if (renewer!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("renewer", renewer);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("renewer", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            if (xattrName == null) {
            }
            if (xattrName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
            }
            if (encoding == null) {
            }
            if (encoding!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("encoding", encoding);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("encoding", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/octet-stream");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public<T >T getAsJson(String delegation, String userName, String doas, String op, String offset, String length, String renewer, String buffersize, String xattrName, String encoding, com.sun.jersey.api.client.GenericType<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (offset == null) {
            }
            if (offset!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("offset", offset);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("offset", ((Object[]) null));
            }
            if (length == null) {
            }
            if (length!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("length", length);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("length", ((Object[]) null));
            }
            if (renewer == null) {
            }
            if (renewer!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("renewer", renewer);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("renewer", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            if (xattrName == null) {
            }
            if (xattrName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
            }
            if (encoding == null) {
            }
            if (encoding!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("encoding", encoding);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("encoding", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (response.getStatus()>= 400) {
                throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
            }
            return response.getEntity(returnType);
        }

        public<T >T getAsJson(String delegation, String userName, String doas, String op, String offset, String length, String renewer, String buffersize, String xattrName, String encoding, Class<T> returnType) {
            UriBuilder localUriBuilder = _uriBuilder.clone();
            if (delegation == null) {
            }
            if (delegation!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
            }
            if (userName == null) {
            }
            if (userName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
            }
            if (doas == null) {
            }
            if (doas!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
            }
            if (op == null) {
            }
            if (op!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
            }
            if (offset == null) {
            }
            if (offset!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("offset", offset);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("offset", ((Object[]) null));
            }
            if (length == null) {
            }
            if (length!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("length", length);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("length", ((Object[]) null));
            }
            if (renewer == null) {
            }
            if (renewer!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("renewer", renewer);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("renewer", ((Object[]) null));
            }
            if (buffersize == null) {
            }
            if (buffersize!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
            }
            if (xattrName == null) {
            }
            if (xattrName!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
            }
            if (encoding == null) {
            }
            if (encoding!= null) {
                localUriBuilder = localUriBuilder.replaceQueryParam("encoding", encoding);
            } else {
                localUriBuilder = localUriBuilder.replaceQueryParam("encoding", ((Object[]) null));
            }
            com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
            com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
            resourceBuilder = resourceBuilder.accept("application/json");
            com.sun.jersey.api.client.ClientResponse response;
            response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
            }
            if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                return response.getEntity(returnType);
            } else {
                return returnType.cast(response);
            }
        }

        public Localhost_WebhdfsV1 .Index.Path path(String path) {
            return new Localhost_WebhdfsV1 .Index.Path(_client, _uriBuilder.buildFromMap(_templateAndMatrixParameterValues), path);
        }

        public static class Path {

            private com.sun.jersey.api.client.Client _client;
            private UriBuilder _uriBuilder;
            private Map<String, Object> _templateAndMatrixParameterValues;

            private Path(com.sun.jersey.api.client.Client client, UriBuilder uriBuilder, Map<String, Object> map) {
                _client = client;
                _uriBuilder = uriBuilder.clone();
                _templateAndMatrixParameterValues = map;
            }

            /**
             * Create new instance using existing Client instance, and a base URI and any parameters
             * 
             */
            public Path(com.sun.jersey.api.client.Client client, URI baseUri, String path) {
                _client = client;
                _uriBuilder = UriBuilder.fromUri(baseUri);
                _uriBuilder = _uriBuilder.path("{path:.*}");
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                _templateAndMatrixParameterValues.put("path", path);
            }

            /**
             * Create new instance using existing Client instance, and the URI from which the parameters will be extracted
             * 
             */
            public Path(com.sun.jersey.api.client.Client client, URI uri) {
                _client = client;
                StringBuilder template = new StringBuilder(BASE_URI.toString());
                if (template.charAt((template.length()- 1))!= '/') {
                    template.append("/{path:.*}");
                } else {
                    template.append("{path:.*}");
                }
                _uriBuilder = UriBuilder.fromPath(template.toString());
                _templateAndMatrixParameterValues = new HashMap<String, Object>();
                UriTemplate uriTemplate = new UriTemplate(template.toString());
                HashMap<String, String> parameters = new HashMap<String, String>();
                uriTemplate.match(uri.toString(), parameters);
                _templateAndMatrixParameterValues.putAll(parameters);
            }

            /**
             * Get path
             * 
             */
            public String getPath() {
                return ((String) _templateAndMatrixParameterValues.get("path"));
            }

            /**
             * Duplicate state and set path
             * 
             */
            public Localhost_WebhdfsV1 .Index.Path setPath(String path) {
                Map<String, Object> copyMap;
                copyMap = new HashMap<String, Object>(_templateAndMatrixParameterValues);
                UriBuilder copyUriBuilder = _uriBuilder.clone();
                copyMap.put("path", path);
                return new Localhost_WebhdfsV1 .Index.Path(_client, copyUriBuilder, copyMap);
            }

            public<T >T getAsOctetStream(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsOctetStream(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T getAsOctetStream(String delegation, String userName, String doas, String op, String offset, String length, String renewer, String buffersize, String xattrName, String encoding, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (offset == null) {
                }
                if (offset!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("offset", offset);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("offset", ((Object[]) null));
                }
                if (length == null) {
                }
                if (length!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("length", length);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("length", ((Object[]) null));
                }
                if (renewer == null) {
                }
                if (renewer!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renewer", renewer);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renewer", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                if (xattrName == null) {
                }
                if (xattrName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
                }
                if (encoding == null) {
                }
                if (encoding!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("encoding", encoding);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("encoding", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsOctetStream(String delegation, String userName, String doas, String op, String offset, String length, String renewer, String buffersize, String xattrName, String encoding, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (offset == null) {
                }
                if (offset!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("offset", offset);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("offset", ((Object[]) null));
                }
                if (length == null) {
                }
                if (length!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("length", length);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("length", ((Object[]) null));
                }
                if (renewer == null) {
                }
                if (renewer!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renewer", renewer);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renewer", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                if (xattrName == null) {
                }
                if (xattrName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
                }
                if (encoding == null) {
                }
                if (encoding!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("encoding", encoding);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("encoding", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T getAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T getAsJson(String delegation, String userName, String doas, String op, String offset, String length, String renewer, String buffersize, String xattrName, String encoding, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (offset == null) {
                }
                if (offset!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("offset", offset);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("offset", ((Object[]) null));
                }
                if (length == null) {
                }
                if (length!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("length", length);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("length", ((Object[]) null));
                }
                if (renewer == null) {
                }
                if (renewer!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renewer", renewer);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renewer", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                if (xattrName == null) {
                }
                if (xattrName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
                }
                if (encoding == null) {
                }
                if (encoding!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("encoding", encoding);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("encoding", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T getAsJson(String delegation, String userName, String doas, String op, String offset, String length, String renewer, String buffersize, String xattrName, String encoding, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (offset == null) {
                }
                if (offset!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("offset", offset);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("offset", ((Object[]) null));
                }
                if (length == null) {
                }
                if (length!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("length", length);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("length", ((Object[]) null));
                }
                if (renewer == null) {
                }
                if (renewer!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renewer", renewer);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renewer", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                if (xattrName == null) {
                }
                if (xattrName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
                }
                if (encoding == null) {
                }
                if (encoding!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("encoding", encoding);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("encoding", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("GET", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T putAsOctetStream(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T putAsOctetStream(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T putAsOctetStream(String delegation, String userName, String doas, String op, String destination, String owner, String group, String permission, String overwrite, String buffersize, String replication, String blocksize, String modificationtime, String accesstime, String renameoptions, String createparent, String token, String aclspec, String xattrName, String xattrValue, String flag, String snapshotname, String oldsnapshotname, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (destination == null) {
                }
                if (destination!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("destination", destination);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("destination", ((Object[]) null));
                }
                if (owner == null) {
                }
                if (owner!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("owner", owner);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("owner", ((Object[]) null));
                }
                if (group == null) {
                }
                if (group!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("group", group);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("group", ((Object[]) null));
                }
                if (permission == null) {
                }
                if (permission!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("permission", permission);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("permission", ((Object[]) null));
                }
                if (overwrite == null) {
                }
                if (overwrite!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", overwrite);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                if (replication == null) {
                }
                if (replication!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("replication", replication);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("replication", ((Object[]) null));
                }
                if (blocksize == null) {
                }
                if (blocksize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", blocksize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", ((Object[]) null));
                }
                if (modificationtime == null) {
                }
                if (modificationtime!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", modificationtime);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", ((Object[]) null));
                }
                if (accesstime == null) {
                }
                if (accesstime!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", accesstime);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", ((Object[]) null));
                }
                if (renameoptions == null) {
                }
                if (renameoptions!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", renameoptions);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", ((Object[]) null));
                }
                if (createparent == null) {
                }
                if (createparent!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("createparent", createparent);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("createparent", ((Object[]) null));
                }
                if (token == null) {
                }
                if (token!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("token", token);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("token", ((Object[]) null));
                }
                if (aclspec == null) {
                }
                if (aclspec!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", aclspec);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", ((Object[]) null));
                }
                if (xattrName == null) {
                }
                if (xattrName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
                }
                if (xattrValue == null) {
                }
                if (xattrValue!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", xattrValue);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", ((Object[]) null));
                }
                if (flag == null) {
                }
                if (flag!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("flag", flag);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("flag", ((Object[]) null));
                }
                if (snapshotname == null) {
                }
                if (snapshotname!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
                }
                if (oldsnapshotname == null) {
                }
                if (oldsnapshotname!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", oldsnapshotname);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T putAsOctetStream(String delegation, String userName, String doas, String op, String destination, String owner, String group, String permission, String overwrite, String buffersize, String replication, String blocksize, String modificationtime, String accesstime, String renameoptions, String createparent, String token, String aclspec, String xattrName, String xattrValue, String flag, String snapshotname, String oldsnapshotname, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (destination == null) {
                }
                if (destination!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("destination", destination);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("destination", ((Object[]) null));
                }
                if (owner == null) {
                }
                if (owner!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("owner", owner);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("owner", ((Object[]) null));
                }
                if (group == null) {
                }
                if (group!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("group", group);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("group", ((Object[]) null));
                }
                if (permission == null) {
                }
                if (permission!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("permission", permission);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("permission", ((Object[]) null));
                }
                if (overwrite == null) {
                }
                if (overwrite!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", overwrite);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                if (replication == null) {
                }
                if (replication!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("replication", replication);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("replication", ((Object[]) null));
                }
                if (blocksize == null) {
                }
                if (blocksize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", blocksize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", ((Object[]) null));
                }
                if (modificationtime == null) {
                }
                if (modificationtime!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", modificationtime);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", ((Object[]) null));
                }
                if (accesstime == null) {
                }
                if (accesstime!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", accesstime);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", ((Object[]) null));
                }
                if (renameoptions == null) {
                }
                if (renameoptions!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", renameoptions);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", ((Object[]) null));
                }
                if (createparent == null) {
                }
                if (createparent!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("createparent", createparent);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("createparent", ((Object[]) null));
                }
                if (token == null) {
                }
                if (token!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("token", token);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("token", ((Object[]) null));
                }
                if (aclspec == null) {
                }
                if (aclspec!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", aclspec);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", ((Object[]) null));
                }
                if (xattrName == null) {
                }
                if (xattrName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
                }
                if (xattrValue == null) {
                }
                if (xattrValue!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", xattrValue);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", ((Object[]) null));
                }
                if (flag == null) {
                }
                if (flag!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("flag", flag);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("flag", ((Object[]) null));
                }
                if (snapshotname == null) {
                }
                if (snapshotname!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
                }
                if (oldsnapshotname == null) {
                }
                if (oldsnapshotname!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", oldsnapshotname);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T putAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T putAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T putAsJson(String delegation, String userName, String doas, String op, String destination, String owner, String group, String permission, String overwrite, String buffersize, String replication, String blocksize, String modificationtime, String accesstime, String renameoptions, String createparent, String token, String aclspec, String xattrName, String xattrValue, String flag, String snapshotname, String oldsnapshotname, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (destination == null) {
                }
                if (destination!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("destination", destination);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("destination", ((Object[]) null));
                }
                if (owner == null) {
                }
                if (owner!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("owner", owner);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("owner", ((Object[]) null));
                }
                if (group == null) {
                }
                if (group!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("group", group);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("group", ((Object[]) null));
                }
                if (permission == null) {
                }
                if (permission!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("permission", permission);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("permission", ((Object[]) null));
                }
                if (overwrite == null) {
                }
                if (overwrite!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", overwrite);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                if (replication == null) {
                }
                if (replication!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("replication", replication);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("replication", ((Object[]) null));
                }
                if (blocksize == null) {
                }
                if (blocksize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", blocksize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", ((Object[]) null));
                }
                if (modificationtime == null) {
                }
                if (modificationtime!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", modificationtime);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", ((Object[]) null));
                }
                if (accesstime == null) {
                }
                if (accesstime!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", accesstime);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", ((Object[]) null));
                }
                if (renameoptions == null) {
                }
                if (renameoptions!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", renameoptions);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", ((Object[]) null));
                }
                if (createparent == null) {
                }
                if (createparent!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("createparent", createparent);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("createparent", ((Object[]) null));
                }
                if (token == null) {
                }
                if (token!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("token", token);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("token", ((Object[]) null));
                }
                if (aclspec == null) {
                }
                if (aclspec!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", aclspec);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", ((Object[]) null));
                }
                if (xattrName == null) {
                }
                if (xattrName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
                }
                if (xattrValue == null) {
                }
                if (xattrValue!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", xattrValue);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", ((Object[]) null));
                }
                if (flag == null) {
                }
                if (flag!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("flag", flag);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("flag", ((Object[]) null));
                }
                if (snapshotname == null) {
                }
                if (snapshotname!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
                }
                if (oldsnapshotname == null) {
                }
                if (oldsnapshotname!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", oldsnapshotname);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T putAsJson(String delegation, String userName, String doas, String op, String destination, String owner, String group, String permission, String overwrite, String buffersize, String replication, String blocksize, String modificationtime, String accesstime, String renameoptions, String createparent, String token, String aclspec, String xattrName, String xattrValue, String flag, String snapshotname, String oldsnapshotname, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (destination == null) {
                }
                if (destination!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("destination", destination);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("destination", ((Object[]) null));
                }
                if (owner == null) {
                }
                if (owner!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("owner", owner);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("owner", ((Object[]) null));
                }
                if (group == null) {
                }
                if (group!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("group", group);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("group", ((Object[]) null));
                }
                if (permission == null) {
                }
                if (permission!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("permission", permission);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("permission", ((Object[]) null));
                }
                if (overwrite == null) {
                }
                if (overwrite!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", overwrite);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("overwrite", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                if (replication == null) {
                }
                if (replication!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("replication", replication);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("replication", ((Object[]) null));
                }
                if (blocksize == null) {
                }
                if (blocksize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", blocksize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("blocksize", ((Object[]) null));
                }
                if (modificationtime == null) {
                }
                if (modificationtime!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", modificationtime);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("modificationtime", ((Object[]) null));
                }
                if (accesstime == null) {
                }
                if (accesstime!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", accesstime);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("accesstime", ((Object[]) null));
                }
                if (renameoptions == null) {
                }
                if (renameoptions!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", renameoptions);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("renameoptions", ((Object[]) null));
                }
                if (createparent == null) {
                }
                if (createparent!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("createparent", createparent);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("createparent", ((Object[]) null));
                }
                if (token == null) {
                }
                if (token!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("token", token);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("token", ((Object[]) null));
                }
                if (aclspec == null) {
                }
                if (aclspec!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", aclspec);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("aclspec", ((Object[]) null));
                }
                if (xattrName == null) {
                }
                if (xattrName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", xattrName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.name", ((Object[]) null));
                }
                if (xattrValue == null) {
                }
                if (xattrValue!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", xattrValue);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("xattr.value", ((Object[]) null));
                }
                if (flag == null) {
                }
                if (flag!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("flag", flag);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("flag", ((Object[]) null));
                }
                if (snapshotname == null) {
                }
                if (snapshotname!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
                }
                if (oldsnapshotname == null) {
                }
                if (oldsnapshotname!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", oldsnapshotname);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("oldsnapshotname", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("PUT", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T deleteAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T deleteAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T deleteAsJson(String delegation, String userName, String doas, String op, String recursive, String snapshotname, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (recursive == null) {
                }
                if (recursive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("recursive", recursive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("recursive", ((Object[]) null));
                }
                if (snapshotname == null) {
                }
                if (snapshotname!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T deleteAsJson(String delegation, String userName, String doas, String op, String recursive, String snapshotname, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (recursive == null) {
                }
                if (recursive!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("recursive", recursive);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("recursive", ((Object[]) null));
                }
                if (snapshotname == null) {
                }
                if (snapshotname!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", snapshotname);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("snapshotname", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("DELETE", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T postAsOctetStream(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsOctetStream(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T postAsOctetStream(String delegation, String userName, String doas, String op, String sources, String buffersize, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (sources == null) {
                }
                if (sources!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("sources", sources);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("sources", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsOctetStream(String delegation, String userName, String doas, String op, String sources, String buffersize, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (sources == null) {
                }
                if (sources!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("sources", sources);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("sources", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/octet-stream");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T postAsJson(com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

            public<T >T postAsJson(String delegation, String userName, String doas, String op, String sources, String buffersize, com.sun.jersey.api.client.GenericType<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (sources == null) {
                }
                if (sources!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("sources", sources);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("sources", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (response.getStatus()>= 400) {
                    throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                }
                return response.getEntity(returnType);
            }

            public<T >T postAsJson(String delegation, String userName, String doas, String op, String sources, String buffersize, Class<T> returnType) {
                UriBuilder localUriBuilder = _uriBuilder.clone();
                if (delegation == null) {
                }
                if (delegation!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", delegation);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("delegation", ((Object[]) null));
                }
                if (userName == null) {
                }
                if (userName!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", userName);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("user.name", ((Object[]) null));
                }
                if (doas == null) {
                }
                if (doas!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", doas);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("doas", ((Object[]) null));
                }
                if (op == null) {
                }
                if (op!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", op);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("op", ((Object[]) null));
                }
                if (sources == null) {
                }
                if (sources!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("sources", sources);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("sources", ((Object[]) null));
                }
                if (buffersize == null) {
                }
                if (buffersize!= null) {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", buffersize);
                } else {
                    localUriBuilder = localUriBuilder.replaceQueryParam("buffersize", ((Object[]) null));
                }
                com.sun.jersey.api.client.WebResource resource = _client.resource(localUriBuilder.buildFromMap(_templateAndMatrixParameterValues));
                com.sun.jersey.api.client.WebResource.Builder resourceBuilder = resource.getRequestBuilder();
                resourceBuilder = resourceBuilder.accept("application/json");
                com.sun.jersey.api.client.ClientResponse response;
                response = resourceBuilder.method("POST", com.sun.jersey.api.client.ClientResponse.class);
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    if (response.getStatus()>= 400) {
                        throw new Localhost_WebhdfsV1 .WebApplicationExceptionMessage(Response.status(response.getClientResponseStatus()).build());
                    }
                }
                if (!com.sun.jersey.api.client.ClientResponse.class.isAssignableFrom(returnType)) {
                    return response.getEntity(returnType);
                } else {
                    return returnType.cast(response);
                }
            }

        }

    }


    /**
     * Workaround for JAX_RS_SPEC-312
     * 
     */
    private static class WebApplicationExceptionMessage
        extends WebApplicationException
    {


        private WebApplicationExceptionMessage(Response response) {
            super(response);
        }

        /**
         * Workaround for JAX_RS_SPEC-312
         * 
         */
        public String getMessage() {
            Response response = getResponse();
            Response.Status status = Response.Status.fromStatusCode(response.getStatus());
            if (status!= null) {
                return (response.getStatus()+(" "+ status.getReasonPhrase()));
            } else {
                return Integer.toString(response.getStatus());
            }
        }

        public String toString() {
            String s = "javax.ws.rs.WebApplicationException";
            String message = getLocalizedMessage();
            return (s +(": "+ message));
        }

    }

}
