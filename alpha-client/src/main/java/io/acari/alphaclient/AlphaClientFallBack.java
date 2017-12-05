package io.acari.alphaclient;

public class AlphaClientFallBack implements AlphaRestClient {
  @Override
  public String getMessageYo() {
    return "Aww snap things when wrong on the backend when trying to talk to alpha service! Try again!";
  }
}
