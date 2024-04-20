package uz.pdp.gson1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    @Expose( )
    private int id;
    @Expose
    private int age;
    @Expose
    private String name;
    @Expose
    private Date date;

    @SerializedName("date_date") //
    @Expose()
    private LocalDate localDate; //
}
