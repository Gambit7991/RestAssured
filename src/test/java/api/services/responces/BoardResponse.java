package api.services.responces;

import api.pojos.BoardPojo;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.*;

@JsonIgnoreProperties(ignoreUnknown = true)
@Data
@ToString(callSuper = true)
@EqualsAndHashCode(callSuper = true)
@NoArgsConstructor
@AllArgsConstructor
public class BoardResponse extends BoardPojo {
    private boolean closed;
    private boolean pinned;
    private String url;
    private String shortUrl;

}
