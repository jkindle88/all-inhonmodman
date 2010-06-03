package business.actions;

import business.actions.converters.ActionEditFileReplaceConverter;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamConverter;

/**
 * Replaces the string pointed to by the "cursor" with the source string.
 * @author Shirkit
 */
@XStreamAlias("replace")
@XStreamConverter(ActionEditFileReplaceConverter.class)
public class ActionEditFileReplace extends Action implements ActionEditFileActions {

    private String content;

    public ActionEditFileReplace() {
        setType(REPLACE);
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

    /**
     * Replaced to be used by the XStreamConverter
     */
    @Override
    public String toString() {
        return "<![CDATA[" + getContent() + "]]>";
    }

}