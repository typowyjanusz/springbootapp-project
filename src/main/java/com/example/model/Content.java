package com.example.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import com.google.common.base.Objects;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

/**
 * Created by Janusz on 2016-01-08.
 */
@Entity(name = "content_view")
public class Content {

    @Id
    @Column(name = "id", nullable = false, updatable = false)
    @GeneratedValue
    private Integer id;

    @NotNull
    @Column(name = "created", nullable = false)
    @DateTimeFormat(pattern="dd-MMM-YYYY")
    private Date created;

    @Column(name = "updated", nullable = false)
    @DateTimeFormat (pattern="dd-MMM-YYYY")
    private Date updated;

    @PrePersist
    protected void onCreate() {
        updated = created = new Date();
    }

    @PreUpdate
    protected void onUpdate() {
        updated = new Date();
    }

    @NotNull
    @Size(max = 1000)
    @Column(name = "contents", nullable = false)
    private String contents;

    private Content() {
    }

    public Content(final Integer id, final String contents, final String title) {
        this.id = id;
        this.contents = contents;
        this.title = title;
    }

    @NotNull
    @Size(max = 1000)
    @Column(name = "title", nullable = false)
    private String title;

    public Integer getId() {
        return id;
    }

    public Date getCreated() {
        return created;
    }

    public String getContents() {
        return contents;
    }

    public String getTitle(){
        return title;
    }

    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("contents", contents)
                .add("title",title)
                .toString();
    }
}