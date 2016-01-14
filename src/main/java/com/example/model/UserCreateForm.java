package com.example.model;

import com.google.common.base.Objects;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.constraints.Size;


/**
 * Created by Janusz on 2016-01-08.
 */
public class UserCreateForm {



    private Integer id;

    @NotEmpty
    @Size(max = 1000)
    private String contents1;

    @NotEmpty
    @Size(max = 1000)
    private String title;



    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getContents1() {
        return contents1;
    }

    public String getTitle(){
        return title;
    }
    public void setTitle(String title){
        this.title = title;
    }



    public void setContents1(String contents1) {
        this.contents1 = contents1;
    }



    @Override
    public String toString() {
        return Objects.toStringHelper(this)
                .add("id", id)
                .add("contents1", contents1)
                .add("title",title)
                .toString();
    }

}
