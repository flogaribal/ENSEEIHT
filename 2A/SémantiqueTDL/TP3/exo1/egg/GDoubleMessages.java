package egg;
import java.util.ResourceBundle;
import mg.egg.eggc.runtime.libjava.messages.NLS;
public class GDoubleMessages extends NLS {
  private static final long serialVersionUID = 1L;
  private static final String BUNDLE_NAME = "GDouble";
  private GDoubleMessages() {
  // Do not instantiate
  }
  static {
  NLS.initializeMessages(BUNDLE_NAME, egg.GDoubleMessages.class);
  }
  private static final ResourceBundle RESOURCE_BUNDLE = ResourceBundle.getBundle(BUNDLE_NAME);
  public static ResourceBundle getResourceBundle() {
  return RESOURCE_BUNDLE;
  }		

  public static  String GDouble_expected_token;
  public static  String GDouble_expected_eof;
  public static  String GDouble_unexpected_token;
  }
