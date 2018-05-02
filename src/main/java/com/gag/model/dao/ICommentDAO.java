package com.gag.model.dao;

import java.util.List;

import com.gag.model.Comment;
import com.gag.model.Post;
import com.gag.model.User;

public interface ICommentDAO {
    
	Comment getCommentById(int id) throws Exception;
	List<Comment> getCommentsByPost(Post post) throws Exception;
	List<Comment> getCommentsByComment(Comment comment) throws Exception;
	int countVotesOfComment(Comment comment) throws Exception;
    void saveComment(Post p, Comment c) throws Exception;
    void deleteComment(Comment c) throws Exception;
    void saveSubComment(Comment parent, Comment child) throws Exception;
    void voteComment(User user, Comment comment, int voteType) throws Exception;
    void deleteCommentVote(User user, Comment comment) throws Exception;
    void updateComment(Comment c) throws Exception;
}
