package com.example.toamto.model;

import org.springframework.beans.factory.annotation.Value;

public class SearchComponentDto extends Component{

    public SearchComponentDto(){
        this.page = 1;
        this.size = 10;
    }


    private Integer page;

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }


    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    private Integer size;
}
