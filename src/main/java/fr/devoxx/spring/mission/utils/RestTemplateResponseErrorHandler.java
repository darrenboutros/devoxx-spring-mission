package fr.devoxx.spring.mission.utils;

import java.io.IOException;
import java.nio.charset.Charset;

import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;
import org.springframework.util.StreamUtils;
import org.springframework.web.client.ResponseErrorHandler;

public class RestTemplateResponseErrorHandler  implements ResponseErrorHandler {

  @Override
  public boolean hasError(ClientHttpResponse httpResponse) 
    throws IOException {

      return (
        httpResponse.getStatusCode().series() == HttpStatus.Series.CLIENT_ERROR
        || httpResponse.getStatusCode().series() == HttpStatus.Series.SERVER_ERROR);
  }

  @Override
  public void handleError(ClientHttpResponse httpResponse) 
    throws IOException {

      if (httpResponse.getStatusCode()
        .series() == HttpStatus.Series.SERVER_ERROR) {
          // handle SERVER_ERROR
      } else if (httpResponse.getStatusCode()
        .series() == HttpStatus.Series.CLIENT_ERROR) {
          // handle CLIENT_ERROR
          if (httpResponse.getStatusCode() == HttpStatus.NOT_FOUND) {
              throw new NotFoundException(StreamUtils.copyToString(httpResponse.getBody(), Charset.defaultCharset()));
          }
      }
  }
}
