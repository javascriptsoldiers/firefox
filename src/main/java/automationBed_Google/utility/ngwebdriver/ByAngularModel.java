package automationBed_Google.utility.ngwebdriver;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.SearchContext;

public class ByAngularModel extends ByAngular.BaseBy {

    public ByAngularModel(String rootSelector, String model) {
        super(rootSelector);
        this.model = model;
    }

    private String model;

    @Override
	protected Object getObject(SearchContext context, JavascriptExecutor javascriptExecutor) {
        return javascriptExecutor.executeScript(
                "var using = arguments[0] || document;\n" +
                        "var rootSelector = '" + rootSelector + "';\n" +
                        "var model = '" + model + "';\n" +
                        "\n" +
                        ByAngular.functions.get("findByModel")
                , context);
    }

    @Override
    public String toString() {
        return "model(" + model + ')';
    }
}
