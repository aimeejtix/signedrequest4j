/* 
 * Copyright 2011 Kazuhiro Sera
 * 
 * Licensed under the Apache License, Version 2.0 (the "License"); 
 * you may not use this file except in compliance with the License. 
 * You may obtain a copy of the License at 
 * 
 *     http://www.apache.org/licenses/LICENSE-2.0 
 * 
 * Unless required by applicable law or agreed to in writing, software 
 * distributed under the License is distributed on an "AS IS" BASIS, 
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, 
 * either express or implied. See the License for the specific language 
 * governing permissions and limitations under the License. 
 */
package com.github.seratch.signedrequest4j;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.util.Map;

/**
 * <pre>
 * Singed OAuth Request
 *
 * - 3 Legged OAuth Request
 * http://oauth.net/core/1.0/#signing_process
 *
 * - 2 Legged Oauth Request a.k.a OAuth Consumer Request, OpenSocial Signed Request
 * http://oauth.googlecode.com/svn/spec/ext/consumer_request/1.0/drafts/1/spec.html
 * </pre>
 *
 * @author <a href="mailto:seratch@gmail.com">Kazuhiro Sera</a>
 */
public interface SignedRequest {

    /**
     * Returns Signed {@link HttpURLConnection} instance.
     *
     * @param url    Request URL
     * @param method HTTP Method
     * @return Signed {@link HttpURLConnection} instance
     * @throws IOException
     */
    HttpURLConnection getHttpURLConnection(String url, HttpMethod method)
            throws IOException;

    /**
     * Set RSA Private Key Value
     *
     * @param rsaPrivateKeyValue RSA Private Key PEM Value
     * @return Self
     */
    public SignedRequest setRsaPrivateKeyValue(String rsaPrivateKeyValue);

    /**
     * Returns OAuth Signature Base String.
     *
     * @param url            Request URL
     * @param method         HTTP Method
     * @param oAuthNonce     OAuth Nonce Value
     * @param oAuthTimestamp OAuth Timestamp Value
     * @return OAuth Signature Base String
     */
    String getSignatureBaseString(String url, HttpMethod method,
                                  String oAuthNonce, Long oAuthTimestamp);

    /**
     * Returns OAuth Signature.
     *
     * @param url            Request URL
     * @param method         HTTP Method
     * @param oAuthNonce     OAuth Nonce Value
     * @param oAuthTimestamp OAuth Timestamp Value
     * @return OAuth Signature
     */
    String getSignature(String url, HttpMethod method, String oAuthNonce,
                        Long oAuthTimestamp);

    /**
     * Do HTTP request and returns Http response
     *
     * @param url               Request URL
     * @param method            HTTP Method
     * @param requestParameters Request parameters(OPTIONAL)
     * @param charset           Charset
     * @return HTTP Response
     * @throws IOException
     */
    HttpResponse doRequest(String url, HttpMethod method,
                           Map<String, Object> requestParameters, String charset)
            throws IOException;

    /**
     * Do GET / HTTP/1.1 request and returns Http response
     *
     * @param url     Request URL
     * @param charset Charset
     * @return HTTP Response
     * @throws IOException
     */
    HttpResponse doGet(String url, String charset) throws IOException;

    /**
     * Do POST / HTTP/1.1 request and returns Http response
     *
     * @param url               Request URL
     * @param requestParameters Request parameters
     * @param charset           Charset
     * @return HTTP Response
     * @throws IOException
     */
    HttpResponse doPost(String url, Map<String, Object> requestParameters,
                        String charset) throws IOException;

    /**
     * Do PUT / HTTP/1.1 request and returns Http response
     *
     * @param url Request URL
     * @return HTTP Response
     * @throws IOException
     */
    HttpResponse doPut(String url) throws IOException;

    /**
     * Do DELETE / HTTP/1.1 request and returns Http response
     *
     * @param url Request URL
     * @return HTTP Response
     * @throws IOException
     */
    HttpResponse doDelete(String url) throws IOException;

    /**
     * Do HEAD / HTTP/1.1 request and returns Http response
     *
     * @param url Request URL
     * @return HTTP Response
     * @throws IOException
     */
    HttpResponse doHead(String url) throws IOException;

    /**
     * Do OPTIONS / HTTP/1.1 request and returns Http response
     *
     * @param url Request URL
     * @return HTTP Response
     * @throws IOException
     */
    HttpResponse doOptions(String url) throws IOException;

    /**
     * Do TRACE / HTTP/1.1 request and returns Http response
     *
     * @param url Request URL
     * @return HTTP Response
     * @throws IOException
     */
    HttpResponse doTrace(String url) throws IOException;

}