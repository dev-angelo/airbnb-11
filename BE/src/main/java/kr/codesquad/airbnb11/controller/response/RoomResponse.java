package kr.codesquad.airbnb11.controller.response;

import java.math.BigDecimal;
import kr.codesquad.airbnb11.domain.room.RoomDTO;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

public class RoomResponse {

  private int id;
  private int maxPersonCount;
  private String mainImage;
  private String title;
  private BigDecimal dailyPrice;
  private String country;
  private boolean isSuperHost;
  private double rating;
  private int reviewCount;
  private BigDecimal latitude;
  private BigDecimal longitude;
  private BigDecimal distance;

  public RoomResponse() {
  }

  public RoomResponse(RoomDTO roomDTO) {
    this.id = roomDTO.getId();
    this.maxPersonCount = roomDTO.getMaxPersonCount();
    this.mainImage = roomDTO.getMainImage();
    this.title = roomDTO.getTitle();
    this.dailyPrice = roomDTO.getDailyPriceFormatted();
    this.country = roomDTO.getCountry();
    this.isSuperHost = roomDTO.getSuperHost();
    this.rating = roomDTO.getRating();
    this.reviewCount = roomDTO.getReviewCount();
    this.latitude = roomDTO.getLatitude();
    this.longitude = roomDTO.getLongitude();
    this.distance = roomDTO.getDistance();
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public int getMaxPersonCount() {
    return maxPersonCount;
  }

  public void setMaxPersonCount(int maxPersonCount) {
    this.maxPersonCount = maxPersonCount;
  }

  public String getMainImage() {
    return mainImage;
  }

  public void setMainImage(String mainImage) {
    this.mainImage = mainImage;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public BigDecimal getDailyPrice() {
    return dailyPrice;
  }

  public void setDailyPrice(BigDecimal dailyPrice) {
    this.dailyPrice = dailyPrice;
  }

  public String getCountry() {
    return country;
  }

  public void setCountry(String country) {
    this.country = country;
  }

  public boolean getSuperHost() {
    return isSuperHost;
  }

  public void setSuperHost(boolean superHost) {
    isSuperHost = superHost;
  }

  public double getRating() {
    return rating;
  }

  public void setRating(double rating) {
    this.rating = rating;
  }

  public int getReviewCount() {
    return reviewCount;
  }

  public void setReviewCount(int reviewCount) {
    this.reviewCount = reviewCount;
  }

  public BigDecimal getLatitude() {
    return latitude;
  }

  public void setLatitude(BigDecimal latitude) {
    this.latitude = latitude;
  }

  public BigDecimal getLongitude() {
    return longitude;
  }

  public void setLongitude(BigDecimal longitude) {
    this.longitude = longitude;
  }

  public boolean isSuperHost() {
    return isSuperHost;
  }

  public BigDecimal getDistance() {
    return distance;
  }

  public void setDistance(BigDecimal distance) {
    this.distance = distance;
  }

  @Override
  public String toString() {
    return new ToStringBuilder(this, ToStringStyle.SHORT_PREFIX_STYLE)
        .append("id", id)
        .append("maxPersonCount", maxPersonCount)
        .append("mainImage", mainImage)
        .append("title", title)
        .append("dailyPrice", dailyPrice)
        .append("country", country)
        .append("isSuperHost", isSuperHost)
        .append("rating", rating)
        .append("reviewCount", reviewCount)
        .append("latitude", latitude)
        .append("longitude", longitude)
        .append("distance", distance)
        .toString();
  }

  public static final class Builder {

    private int id;
    private int maxPersonCount;
    private String mainImage;
    private String title;
    private BigDecimal dailyPrice;
    private String country;
    private boolean isSuperHost;
    private double rating;
    private int reviewCount;
    private BigDecimal latitude;
    private BigDecimal longitude;
    private BigDecimal distance;

    private Builder() {
    }

    public static Builder aRoomResponse() {
      return new Builder();
    }

    public Builder id(int id) {
      this.id = id;
      return this;
    }

    public Builder maxPersonCount(int maxPersonCount) {
      this.maxPersonCount = maxPersonCount;
      return this;
    }

    public Builder mainImage(String mainImage) {
      this.mainImage = mainImage;
      return this;
    }

    public Builder title(String title) {
      this.title = title;
      return this;
    }

    public Builder dailyPrice(BigDecimal dailyPrice) {
      this.dailyPrice = dailyPrice;
      return this;
    }

    public Builder country(String country) {
      this.country = country;
      return this;
    }

    public Builder isSuperHost(boolean isSuperHost) {
      this.isSuperHost = isSuperHost;
      return this;
    }

    public Builder rating(double rating) {
      this.rating = rating;
      return this;
    }

    public Builder reviewCount(int reviewCount) {
      this.reviewCount = reviewCount;
      return this;
    }

    public Builder latitude(BigDecimal latitude) {
      this.latitude = latitude;
      return this;
    }

    public Builder longitude(BigDecimal longitude) {
      this.longitude = longitude;
      return this;
    }

    public Builder distance(BigDecimal distance) {
      this.distance = distance;
      return this;
    }

    public RoomResponse build() {
      RoomResponse roomResponse = new RoomResponse();
      roomResponse.setId(id);
      roomResponse.setMaxPersonCount(maxPersonCount);
      roomResponse.setMainImage(mainImage);
      roomResponse.setTitle(title);
      roomResponse.setDailyPrice(dailyPrice);
      roomResponse.setCountry(country);
      roomResponse.setRating(rating);
      roomResponse.setReviewCount(reviewCount);
      roomResponse.setSuperHost(isSuperHost);
      roomResponse.setLatitude(latitude);
      roomResponse.setLongitude(longitude);
      roomResponse.setDistance(distance);
      return roomResponse;
    }
  }
}
