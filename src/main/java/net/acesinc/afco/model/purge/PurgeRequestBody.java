package net.acesinc.afco.model.purge;

import java.util.List;
import lombok.Data;

@Data
public class PurgeRequestBody {
    private String justification;
    private List<String> mappingIds;
    private List<String> dataFileIds;
    private Boolean autoApprove;
}
