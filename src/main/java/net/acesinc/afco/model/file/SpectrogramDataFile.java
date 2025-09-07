package net.acesinc.afco.model.file;

import com.fasterxml.jackson.annotation.JsonView;
import net.acesinc.afco.model.spectrogram.SpectrogramMetadata;
import net.acesinc.afco.model.view.Views;

public class SpectrogramDataFile extends DataFile {

    @JsonView(Views.FullView.class)
    private SpectrogramMetadata data;

    public SpectrogramMetadata getData() {
        return data;
    }

    public void setData(SpectrogramMetadata data) {
        this.data = data;
    }
}
