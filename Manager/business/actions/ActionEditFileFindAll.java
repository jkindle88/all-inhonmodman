package business.actions;

import business.actions.converters.ActionEditFileFindAllConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamAsAttribute;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * @author Shirkit
 */
@XStreamAlias("findall")
@XStreamConverter(ActionEditFileFindAllConverter.class)
public class ActionEditFileFindAll extends Action implements ActionEditFileActions {

    @XStreamAlias("position")
    @XStreamAsAttribute
    private String content;

    public ActionEditFileFindAll() {
        setType(FIND);
    }

    /**
     * @return the content
     */
    public String getContent() {
        return content;
    }

    /**
     * @param content the content to set
     */
    public void setContent(String content) {
        this.content = content;
    }
}
