package com.example.movie.DTO;
import com.example.movie.model.Movie;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
public class MovieDTO {
    private int MovieDuration;
    private LocalDateTime EndTime;
    private LocalDateTime PremiereDate;
    private String Description;
    private String Director;
    private String Image;
    private String Language;
    private String HeroImage;
    private String Name;
    private String Trailer;
    private boolean IsActive;
    public static MovieDTO fromEntity(Movie movie){
        return new MovieDTO(
                movie.getMovieDuration(),
                movie.getEndTime(),
                movie.getPremiereDate(),
                movie.getDescription(),
                movie.getDirector(),
                movie.getImage(),
                movie.getLanguage(),
                movie.getHeroImage(),
                movie.getName(),
                movie.getTrailer(),
                movie.isIsActive()
        );
    }
}
