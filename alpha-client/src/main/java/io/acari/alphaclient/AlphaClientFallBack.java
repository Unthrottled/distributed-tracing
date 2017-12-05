package io.acari.alphaclient;

public class AlphaClientFallBack implements AlphaRestClient{
  @Override
  public String getMessageYo() {
    return "Aww snap things are broken! Try again!";
  }
}
