package Controllers;

import Models.PostDAO;
import Pojos.Post;
import java.io.Serializable;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;


/**
 *
 * @author alexf
 */
@ManagedBean(name="facePost")
public class FacePost  implements Serializable{

    Post post= new Post();
    PostDAO postdao = new PostDAO();
    List<Post> allpost = new ArrayList<>();

    public FacePost() throws SQLException {
        allpost= postdao.findPosts();
        
    }
    
    


    public List<Post> getAllpost() {
        return allpost;
    }

    public void setAllpost(List<Post> allpost) {
        this.allpost = allpost;
    }
    
    
    public PostDAO getPostdao() {
        return postdao;
    }

    public void setPostdao(PostDAO postdao) {
        this.postdao = postdao;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public void savePost() {

        try {
            
             //neseito el id del user que la guardo...
        //  post.setUser_Id(faceuser.loginOn.getId());
            postdao.savePost(this.post);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.post = new Post();
        }

    }

    public void deletePost(){
    try {postdao.deletePost(this.post.getId());
    }catch(SQLException e){
     System.out.println(e.getMessage());
    }finally{
        System.err.println("se elimino el post");
    }
    }
     
     public void updatePost() {

        try {
            postdao.updatePost(this.post);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        } finally {
            this.post = new Post();
        }

    }
}
