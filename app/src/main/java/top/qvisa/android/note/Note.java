package top.qvisa.android.note;

public class Note {

    public String Title;
    public String Content;

    public Note(String title,String content)
    {
        this.Title= title;
        this.Content = content;
    }

    public String getContent() {
        return Content;
    }

    public String getTitle() {
        return Title;
    }
}

