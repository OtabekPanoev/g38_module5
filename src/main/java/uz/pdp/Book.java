package uz.pdp;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import com.google.gson.annotations.Since;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
public class Book {

    @Expose
    @SerializedName("id")
    private Integer bookId;

    @Expose(deserialize = false)
    @SerializedName("title")
    protected String bookTitle;

    @Expose
    @SerializedName("author")
    private String bookAuthor;

    @Since(1.0)
    @Expose
    private volatile Date bookDate;
    @Expose
    private LocalDate publishedDate;
}