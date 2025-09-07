package net.acesinc.afco.model.jsp;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import lombok.Data;
import lombok.NonNull;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document(collection = "jspServers")
@JsonPropertyOrder({"id", "site", "machine", "host"})
public class JspServer {

    @Id
    private String id;

    @NonNull
    private String site;

    @NonNull
    private String machine;

    @NonNull
    private String host;
}
