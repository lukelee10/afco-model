package net.acesinc.afco.model.file.pyspeech;

import java.util.Date;
import java.util.List;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PyspeechTranscript {
    private String audiokey;
    private String language;
    private String modelName;
    private Date requestedDate;
    private Date completedDate;
    private List<Word> words;
}
