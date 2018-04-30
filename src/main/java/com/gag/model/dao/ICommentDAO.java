package com.gag.model.dao;

import com.gag.model.Comment;
import com.gag.model.Post;

public interface ICommentDAO {
    
	Comment getCommentById(int id) throws Exception;
    void saveComment(Post p, Comment c) throws Exception;
    void deleteComment(Comment c) throws Exception;
    void saveSubComment(Comment parent, Comment child) throws Exception;
    // void updateComment(Comment c) throws Exception;
}
