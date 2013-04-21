import com.att.phutungoto.Article;
class BootStrap {

    def init = { servletContext ->
		Article.search().createIndexAndWait();
    }
    def destroy = {
    }
}
