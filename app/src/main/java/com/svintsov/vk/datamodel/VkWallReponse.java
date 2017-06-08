
package com.svintsov.vk.datamodel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.List;

public class VkWallReponse {

    @SerializedName("response")
    @Expose
    private List<Response> response = null;

    public List<Response> getResponse() {
        return response;
    }

    public void setResponse(List<Response> response) {
        this.response = response;
    }

    public static class Attachment {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("link")
        @Expose
        private Link link;
        @SerializedName("video")
        @Expose
        private Video video;
        @SerializedName("photo")
        @Expose
        private Photo photo;
        @SerializedName("poll")
        @Expose
        private Poll poll;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Link getLink() {
            return link;
        }

        public void setLink(Link link) {
            this.link = link;
        }

        public Video getVideo() {
            return video;
        }

        public void setVideo(Video video) {
            this.video = video;
        }

        public Photo getPhoto() {
            return photo;
        }

        public void setPhoto(Photo photo) {
            this.photo = photo;
        }

        public Poll getPoll() {
            return poll;
        }

        public void setPoll(Poll poll) {
            this.poll = poll;
        }

    }

    public static class Attachment_ {

        @SerializedName("type")
        @Expose
        private String type;
        @SerializedName("link")
        @Expose
        private Link_ link;
        @SerializedName("video")
        @Expose
        private Video_ video;
        @SerializedName("photo")
        @Expose
        private Photo_ photo;
        @SerializedName("poll")
        @Expose
        private Poll_ poll;
        @SerializedName("page")
        @Expose
        private Page page;

        public String getType() {
            return type;
        }

        public void setType(String type) {
            this.type = type;
        }

        public Link_ getLink() {
            return link;
        }

        public void setLink(Link_ link) {
            this.link = link;
        }

        public Video_ getVideo() {
            return video;
        }

        public void setVideo(Video_ video) {
            this.video = video;
        }

        public Photo_ getPhoto() {
            return photo;
        }

        public void setPhoto(Photo_ photo) {
            this.photo = photo;
        }

        public Poll_ getPoll() {
            return poll;
        }

        public void setPoll(Poll_ poll) {
            this.poll = poll;
        }

        public Page getPage() {
            return page;
        }

        public void setPage(Page page) {
            this.page = page;
        }

    }

    public static class Comments {

        @SerializedName("count")
        @Expose
        private Integer count;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

    }

    public static class Likes {

        @SerializedName("count")
        @Expose
        private Integer count;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

    }

    public static class Link {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("target")
        @Expose
        private String target;
        @SerializedName("image_src")
        @Expose
        private String imageSrc;
        @SerializedName("image_big")
        @Expose
        private String imageBig;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getImageSrc() {
            return imageSrc;
        }

        public void setImageSrc(String imageSrc) {
            this.imageSrc = imageSrc;
        }

        public String getImageBig() {
            return imageBig;
        }

        public void setImageBig(String imageBig) {
            this.imageBig = imageBig;
        }

    }

    public static class Link_ {

        @SerializedName("url")
        @Expose
        private String url;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("target")
        @Expose
        private String target;
        @SerializedName("image_src")
        @Expose
        private String imageSrc;
        @SerializedName("image_big")
        @Expose
        private String imageBig;

        public String getUrl() {
            return url;
        }

        public void setUrl(String url) {
            this.url = url;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getTarget() {
            return target;
        }

        public void setTarget(String target) {
            this.target = target;
        }

        public String getImageSrc() {
            return imageSrc;
        }

        public void setImageSrc(String imageSrc) {
            this.imageSrc = imageSrc;
        }

        public String getImageBig() {
            return imageBig;
        }

        public void setImageBig(String imageBig) {
            this.imageBig = imageBig;
        }

    }

    public static class Page {

        @SerializedName("pid")
        @Expose
        private String pid;
        @SerializedName("gid")
        @Expose
        private Integer gid;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("view_url")
        @Expose
        private String viewUrl;

        public String getPid() {
            return pid;
        }

        public void setPid(String pid) {
            this.pid = pid;
        }

        public Integer getGid() {
            return gid;
        }

        public void setGid(Integer gid) {
            this.gid = gid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getViewUrl() {
            return viewUrl;
        }

        public void setViewUrl(String viewUrl) {
            this.viewUrl = viewUrl;
        }

    }

    public static class Photo {

        @SerializedName("pid")
        @Expose
        private Integer pid;
        @SerializedName("aid")
        @Expose
        private Integer aid;
        @SerializedName("owner_id")
        @Expose
        private Integer ownerId;
        @SerializedName("src")
        @Expose
        private String src;
        @SerializedName("src_big")
        @Expose
        private String srcBig;
        @SerializedName("src_small")
        @Expose
        private String srcSmall;
        @SerializedName("src_xbig")
        @Expose
        private String srcXbig;
        @SerializedName("src_xxbig")
        @Expose
        private String srcXxbig;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("created")
        @Expose
        private Integer created;
        @SerializedName("src_xxxbig")
        @Expose
        private String srcXxxbig;
        @SerializedName("post_id")
        @Expose
        private Integer postId;
        @SerializedName("access_key")
        @Expose
        private String accessKey;
        @SerializedName("user_id")
        @Expose
        private Integer userId;

        public Integer getPid() {
            return pid;
        }

        public void setPid(Integer pid) {
            this.pid = pid;
        }

        public Integer getAid() {
            return aid;
        }

        public void setAid(Integer aid) {
            this.aid = aid;
        }

        public Integer getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Integer ownerId) {
            this.ownerId = ownerId;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getSrcBig() {
            return srcBig;
        }

        public void setSrcBig(String srcBig) {
            this.srcBig = srcBig;
        }

        public String getSrcSmall() {
            return srcSmall;
        }

        public void setSrcSmall(String srcSmall) {
            this.srcSmall = srcSmall;
        }

        public String getSrcXbig() {
            return srcXbig;
        }

        public void setSrcXbig(String srcXbig) {
            this.srcXbig = srcXbig;
        }

        public String getSrcXxbig() {
            return srcXxbig;
        }

        public void setSrcXxbig(String srcXxbig) {
            this.srcXxbig = srcXxbig;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getCreated() {
            return created;
        }

        public void setCreated(Integer created) {
            this.created = created;
        }

        public String getSrcXxxbig() {
            return srcXxxbig;
        }

        public void setSrcXxxbig(String srcXxxbig) {
            this.srcXxxbig = srcXxxbig;
        }

        public Integer getPostId() {
            return postId;
        }

        public void setPostId(Integer postId) {
            this.postId = postId;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

    }

    public static class Photo_ {

        @SerializedName("pid")
        @Expose
        private Integer pid;
        @SerializedName("aid")
        @Expose
        private Integer aid;
        @SerializedName("owner_id")
        @Expose
        private Integer ownerId;
        @SerializedName("src")
        @Expose
        private String src;
        @SerializedName("src_big")
        @Expose
        private String srcBig;
        @SerializedName("src_small")
        @Expose
        private String srcSmall;
        @SerializedName("src_xbig")
        @Expose
        private String srcXbig;
        @SerializedName("src_xxbig")
        @Expose
        private String srcXxbig;
        @SerializedName("width")
        @Expose
        private Integer width;
        @SerializedName("height")
        @Expose
        private Integer height;
        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("created")
        @Expose
        private Integer created;
        @SerializedName("src_xxxbig")
        @Expose
        private String srcXxxbig;
        @SerializedName("post_id")
        @Expose
        private Integer postId;
        @SerializedName("access_key")
        @Expose
        private String accessKey;
        @SerializedName("user_id")
        @Expose
        private Integer userId;

        public Integer getPid() {
            return pid;
        }

        public void setPid(Integer pid) {
            this.pid = pid;
        }

        public Integer getAid() {
            return aid;
        }

        public void setAid(Integer aid) {
            this.aid = aid;
        }

        public Integer getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Integer ownerId) {
            this.ownerId = ownerId;
        }

        public String getSrc() {
            return src;
        }

        public void setSrc(String src) {
            this.src = src;
        }

        public String getSrcBig() {
            return srcBig;
        }

        public void setSrcBig(String srcBig) {
            this.srcBig = srcBig;
        }

        public String getSrcSmall() {
            return srcSmall;
        }

        public void setSrcSmall(String srcSmall) {
            this.srcSmall = srcSmall;
        }

        public String getSrcXbig() {
            return srcXbig;
        }

        public void setSrcXbig(String srcXbig) {
            this.srcXbig = srcXbig;
        }

        public String getSrcXxbig() {
            return srcXxbig;
        }

        public void setSrcXxbig(String srcXxbig) {
            this.srcXxbig = srcXxbig;
        }

        public Integer getWidth() {
            return width;
        }

        public void setWidth(Integer width) {
            this.width = width;
        }

        public Integer getHeight() {
            return height;
        }

        public void setHeight(Integer height) {
            this.height = height;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Integer getCreated() {
            return created;
        }

        public void setCreated(Integer created) {
            this.created = created;
        }

        public String getSrcXxxbig() {
            return srcXxxbig;
        }

        public void setSrcXxxbig(String srcXxxbig) {
            this.srcXxxbig = srcXxxbig;
        }

        public Integer getPostId() {
            return postId;
        }

        public void setPostId(Integer postId) {
            this.postId = postId;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public Integer getUserId() {
            return userId;
        }

        public void setUserId(Integer userId) {
            this.userId = userId;
        }

    }

    public static class Poll {

        @SerializedName("poll_id")
        @Expose
        private Integer pollId;
        @SerializedName("question")
        @Expose
        private String question;

        public Integer getPollId() {
            return pollId;
        }

        public void setPollId(Integer pollId) {
            this.pollId = pollId;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

    }

    public static class Poll_ {

        @SerializedName("poll_id")
        @Expose
        private Integer pollId;
        @SerializedName("question")
        @Expose
        private String question;

        public Integer getPollId() {
            return pollId;
        }

        public void setPollId(Integer pollId) {
            this.pollId = pollId;
        }

        public String getQuestion() {
            return question;
        }

        public void setQuestion(String question) {
            this.question = question;
        }

    }

    public static class Reposts {

        @SerializedName("count")
        @Expose
        private Integer count;

        public Integer getCount() {
            return count;
        }

        public void setCount(Integer count) {
            this.count = count;
        }

    }

    public static class Response {

        @SerializedName("id")
        @Expose
        private Integer id;
        @SerializedName("from_id")
        @Expose
        private Integer fromId;
        @SerializedName("to_id")
        @Expose
        private Integer toId;
        @SerializedName("date")
        @Expose
        private Integer date;
        @SerializedName("post_type")
        @Expose
        private String postType;
        @SerializedName("text")
        @Expose
        private String text;
        @SerializedName("attachment")
        @Expose
        private Attachment attachment;
        @SerializedName("attachments")
        @Expose
        private List<Attachment_> attachments = null;
        @SerializedName("comments")
        @Expose
        private Comments comments;
        @SerializedName("likes")
        @Expose
        private Likes likes;
        @SerializedName("reposts")
        @Expose
        private Reposts reposts;
        @SerializedName("copy_post_date")
        @Expose
        private Integer copyPostDate;
        @SerializedName("copy_post_type")
        @Expose
        private String copyPostType;
        @SerializedName("copy_owner_id")
        @Expose
        private Integer copyOwnerId;
        @SerializedName("copy_post_id")
        @Expose
        private Integer copyPostId;
        @SerializedName("copy_text")
        @Expose
        private String copyText;
        @SerializedName("signer_id")
        @Expose
        private Integer signerId;

        public Integer getId() {
            return id;
        }

        public void setId(Integer id) {
            this.id = id;
        }

        public Integer getFromId() {
            return fromId;
        }

        public void setFromId(Integer fromId) {
            this.fromId = fromId;
        }

        public Integer getToId() {
            return toId;
        }

        public void setToId(Integer toId) {
            this.toId = toId;
        }

        public Integer getDate() {
            return date;
        }

        public void setDate(Integer date) {
            this.date = date;
        }

        public String getPostType() {
            return postType;
        }

        public void setPostType(String postType) {
            this.postType = postType;
        }

        public String getText() {
            return text;
        }

        public void setText(String text) {
            this.text = text;
        }

        public Attachment getAttachment() {
            return attachment;
        }

        public void setAttachment(Attachment attachment) {
            this.attachment = attachment;
        }

        public List<Attachment_> getAttachments() {
            return attachments;
        }

        public void setAttachments(List<Attachment_> attachments) {
            this.attachments = attachments;
        }

        public Comments getComments() {
            return comments;
        }

        public void setComments(Comments comments) {
            this.comments = comments;
        }

        public Likes getLikes() {
            return likes;
        }

        public void setLikes(Likes likes) {
            this.likes = likes;
        }

        public Reposts getReposts() {
            return reposts;
        }

        public void setReposts(Reposts reposts) {
            this.reposts = reposts;
        }

        public Integer getCopyPostDate() {
            return copyPostDate;
        }

        public void setCopyPostDate(Integer copyPostDate) {
            this.copyPostDate = copyPostDate;
        }

        public String getCopyPostType() {
            return copyPostType;
        }

        public void setCopyPostType(String copyPostType) {
            this.copyPostType = copyPostType;
        }

        public Integer getCopyOwnerId() {
            return copyOwnerId;
        }

        public void setCopyOwnerId(Integer copyOwnerId) {
            this.copyOwnerId = copyOwnerId;
        }

        public Integer getCopyPostId() {
            return copyPostId;
        }

        public void setCopyPostId(Integer copyPostId) {
            this.copyPostId = copyPostId;
        }

        public String getCopyText() {
            return copyText;
        }

        public void setCopyText(String copyText) {
            this.copyText = copyText;
        }

        public Integer getSignerId() {
            return signerId;
        }

        public void setSignerId(Integer signerId) {
            this.signerId = signerId;
        }

    }

    public static class Video {

        @SerializedName("vid")
        @Expose
        private Integer vid;
        @SerializedName("owner_id")
        @Expose
        private Integer ownerId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("duration")
        @Expose
        private Integer duration;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("date")
        @Expose
        private Integer date;
        @SerializedName("views")
        @Expose
        private Integer views;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("image_big")
        @Expose
        private String imageBig;
        @SerializedName("image_small")
        @Expose
        private String imageSmall;
        @SerializedName("image_xbig")
        @Expose
        private String imageXbig;
        @SerializedName("access_key")
        @Expose
        private String accessKey;
        @SerializedName("platform")
        @Expose
        private String platform;

        public Integer getVid() {
            return vid;
        }

        public void setVid(Integer vid) {
            this.vid = vid;
        }

        public Integer getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Integer ownerId) {
            this.ownerId = ownerId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getDate() {
            return date;
        }

        public void setDate(Integer date) {
            this.date = date;
        }

        public Integer getViews() {
            return views;
        }

        public void setViews(Integer views) {
            this.views = views;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImageBig() {
            return imageBig;
        }

        public void setImageBig(String imageBig) {
            this.imageBig = imageBig;
        }

        public String getImageSmall() {
            return imageSmall;
        }

        public void setImageSmall(String imageSmall) {
            this.imageSmall = imageSmall;
        }

        public String getImageXbig() {
            return imageXbig;
        }

        public void setImageXbig(String imageXbig) {
            this.imageXbig = imageXbig;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

    }

    public static class Video_ {

        @SerializedName("vid")
        @Expose
        private Integer vid;
        @SerializedName("owner_id")
        @Expose
        private Integer ownerId;
        @SerializedName("title")
        @Expose
        private String title;
        @SerializedName("duration")
        @Expose
        private Integer duration;
        @SerializedName("description")
        @Expose
        private String description;
        @SerializedName("date")
        @Expose
        private Integer date;
        @SerializedName("views")
        @Expose
        private Integer views;
        @SerializedName("image")
        @Expose
        private String image;
        @SerializedName("image_big")
        @Expose
        private String imageBig;
        @SerializedName("image_small")
        @Expose
        private String imageSmall;
        @SerializedName("image_xbig")
        @Expose
        private String imageXbig;
        @SerializedName("access_key")
        @Expose
        private String accessKey;
        @SerializedName("platform")
        @Expose
        private String platform;

        public Integer getVid() {
            return vid;
        }

        public void setVid(Integer vid) {
            this.vid = vid;
        }

        public Integer getOwnerId() {
            return ownerId;
        }

        public void setOwnerId(Integer ownerId) {
            this.ownerId = ownerId;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public Integer getDuration() {
            return duration;
        }

        public void setDuration(Integer duration) {
            this.duration = duration;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public Integer getDate() {
            return date;
        }

        public void setDate(Integer date) {
            this.date = date;
        }

        public Integer getViews() {
            return views;
        }

        public void setViews(Integer views) {
            this.views = views;
        }

        public String getImage() {
            return image;
        }

        public void setImage(String image) {
            this.image = image;
        }

        public String getImageBig() {
            return imageBig;
        }

        public void setImageBig(String imageBig) {
            this.imageBig = imageBig;
        }

        public String getImageSmall() {
            return imageSmall;
        }

        public void setImageSmall(String imageSmall) {
            this.imageSmall = imageSmall;
        }

        public String getImageXbig() {
            return imageXbig;
        }

        public void setImageXbig(String imageXbig) {
            this.imageXbig = imageXbig;
        }

        public String getAccessKey() {
            return accessKey;
        }

        public void setAccessKey(String accessKey) {
            this.accessKey = accessKey;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

    }
}