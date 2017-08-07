package com.example.hamid_pc.ritekitcodingchallenge;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;


class Influencer {

    @SerializedName("username")
    @Expose
    private String username;
    @SerializedName("photo")
    @Expose
    private String photo;
    @SerializedName("followers")
    @Expose
    private Integer followers;

    /**
     * No args constructor for use in serialization
     *
     */
    public Influencer() {
    }

    /**
     *
     * @param followers
     * @param username
     * @param photo
     */
    public Influencer(String username, String photo, Integer followers) {
        super();
        this.username = username;
        this.photo = photo;
        this.followers = followers;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public Integer getFollowers() {
        return followers;
    }

    public void setFollowers(Integer followers) {
        this.followers = followers;
    }

}

public class InfluencerResponse {

    @SerializedName("result")
    @Expose
    private Boolean result;
    @SerializedName("code")
    @Expose
    private Integer code;
    @SerializedName("message")
    @Expose
    private String message;
    @SerializedName("hashtag")
    @Expose
    private String hashtag;
    @SerializedName("influencers")
    @Expose
    private List<Influencer> influencers = null;

    /**
     * No args constructor for use in serialization
     *
     */
    public InfluencerResponse() {
    }

    /**
     *
     * @param message
     * @param result
     * @param hashtag
     * @param influencers
     * @param code
     */
    public InfluencerResponse(Boolean result, Integer code, String message, String hashtag, List<Influencer> influencers) {
        super();
        this.result = result;
        this.code = code;
        this.message = message;
        this.hashtag = hashtag;
        this.influencers = influencers;
    }

    public Boolean getResult() {
        return result;
    }

    public void setResult(Boolean result) {
        this.result = result;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getHashtag() {
        return hashtag;
    }

    public void setHashtag(String hashtag) {
        this.hashtag = hashtag;
    }

    public List<Influencer> getInfluencers() {
        return influencers;
    }

    public void setInfluencers(List<Influencer> influencers) {
        this.influencers = influencers;
    }

}
