package de.smartsquare.dotlang.webview

import freemarker.ext.beans.BeansWrapper
import freemarker.template.Configuration
import freemarker.template.DefaultObjectWrapper
import freemarker.template.TemplateException
import freemarker.template.TemplateExceptionHandler
import org.springframework.stereotype.Component
import java.io.File
import java.io.IOException
import java.io.StringWriter

/**
 * Freemarker Wrapper Service to process FTL templates. The template root
 * directory is expected at `com/intellivat/modeler/template`
 */
@Component
class FreemarkerHtmlRenderer {

    private val cfg: Configuration

    @Throws(IOException::class)
    internal constructor() {
        cfg = Configuration(Configuration.VERSION_2_3_23)
        cfg.setDirectoryForTemplateLoading(File("src/main/resources/templates"))
        cfg.setDefaultEncoding("UTF-8")
        cfg.setTemplateExceptionHandler(TemplateExceptionHandler.RETHROW_HANDLER)
        val defaultObjectWrapper = DefaultObjectWrapper(Configuration.VERSION_2_3_23)
        defaultObjectWrapper.setExposureLevel(BeansWrapper.EXPOSE_ALL)
        defaultObjectWrapper.setExposeFields(true)
        cfg.setObjectWrapper(defaultObjectWrapper)
        // for accessing maps with objects as keys
        cfg.setAPIBuiltinEnabled(true)
    }

    
    /**
     * Build the label for a [com.intellivat.domain.taxtree.ResultNode]
     * using the `inputData` for the template values.
     *
     * @param inputData
     * @return
     */
    fun buildResultNodeLabel(inputData: Map<String, Any>): String {
        return processTemplate("ResultNodeBodyLabel.ftl", inputData)
    }


    /**
     * Processes the given FTL template and interprets the input data map.
     *
     * @param templateName
     * @param inputData
     * @return the String representation of the processed template
     * @throws IOException
     * @throws TemplateException
     */
    @JvmOverloads
    internal fun processTemplate(templateName: String, inputData: Map<String, Any>? = null): String {
        try {

            val temp = cfg.getTemplate(templateName)

            val out = StringWriter()
            temp.process(inputData, out)

            return out.toString()
        } catch (ex: IOException) {
            throw IllegalStateException("An Exception occured while rendering the node body.", ex)
        } catch (ex: TemplateException) {
            throw IllegalStateException("An Exception occured while rendering the node body.", ex)
        }

    }
}
