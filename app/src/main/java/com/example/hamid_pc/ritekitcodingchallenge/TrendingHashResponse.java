package com.example.hamid_pc.ritekitcodingchallenge;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

class Tag {

    @SerializedName("tag")
    @Expose
    private String tag;
    @SerializedName("tweets")
    @Expose
    private Integer tweets;
    @SerializedName("retweets")
    @Expose
    private Integer retweets;
    @SerializedName("exposure")
    @Expose
    private Integer exposure;
    @SerializedName("links")
    @Expose
    private Double links;
    @SerializedName("photos")
    @Expose
    private Double photos;
    @SerializedName("mentions")
    @Expose
    private Float mentions;
    @SerializedName("color")
    @Expose
    private Integer color;

    /**
     * No args constructor for use in serialization
     */
    public Tag() {
    }

    /**
     * @param photos
     * @param exposure
     * @param color
     * @param tag
     * @param links
     * @param tweets
     * @param mentions
     * @param retweets
     */
    public Tag(String tag, Integer tweets, Integer retweets, Integer exposure, Double links, Double photos, Float mentions, Integer color) {
        super();
        this.tag = tag;
        this.tweets = tweets;
        this.retweets = retweets;
        this.exposure = exposure;
        this.links = links;
        this.photos = photos;
        this.mentions = mentions;
        this.color = color;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public Integer getTweets() {
        return tweets;
    }

    public void setTweets(Integer tweets) {
        this.tweets = tweets;
    }

    public Integer getRetweets() {
        return retweets;
    }

    public void setRetweets(Integer retweets) {
        this.retweets = retweets;
    }

    public Integer getExposure() {
        return exposure;
    }

    public void setExposure(Integer exposure) {
        this.exposure = exposure;
    }

    public Double getLinks() {
        return links;
    }

    public void setLinks(Double links) {
        this.links = links;
    }

    public Double getPhotos() {
        return photos;
    }

    public void setPhotos(Double photos) {
        this.photos = photos;
    }

    public Float getMentions() {
        return mentions;
    }

    public void setMentions(Float mentions) {
        this.mentions = mentions;
    }

    public Integer getColor() {
        return color;
    }

    public void setColor(Integer color) {
        this.color = color;
    }

}


public class TrendingHashResponse {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("tags")
    @Expose
    private List<Tag> tags = null;

    /**
     * No args constructor for use in serialization
     */
    public TrendingHashResponse() {
    }

    /**
     * @param tags
     * @param message
     * @param result
     * @param code
     */
    public TrendingHashResponse(Boolean result, String message, Integer code, List<Tag> tags) {
        super();
        this.result = result;
        this.message = message;
        this.code = code;
        this.tags = tags;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public List<Tag> getTags() {
        return tags;
    }

    public void setTags(List<Tag> tags) {
        this.tags = tags;
    }

}
