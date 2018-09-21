package com.dy.dao;

import com.dy.bean.CommandContent;

import java.util.List;

public interface ICommandContent {
    public void insertBatch(List<CommandContent> contentList);
}
