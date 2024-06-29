package us.deathmarine.luyten.decompiler;

import com.strobel.assembler.metadata.TypeDefinition;
import org.objectweb.asm.ClassReader;
import org.objectweb.asm.util.ASMifier;
import org.objectweb.asm.util.TraceClassVisitor;
import us.deathmarine.luyten.Model;
import us.deathmarine.luyten.util.ProcyonUtils;

import java.io.ByteArrayOutputStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Set;

public class ASMTextProvider implements LinkProvider {

    private String content;

    @Override
    public void generateContent() {
    }

    @Override
    public void setType(TypeDefinition type, Model model) {
        var bytes = ProcyonUtils.getContent(type, model);
        var out = new ByteArrayOutputStream();
        new ClassReader(bytes).accept(new TraceClassVisitor(new PrintWriter(out)), 0);
        content = out.toString();
    }

    @Override
    public String getTextContent() {
        return content;
    }

    @Override
    public void processLinks() {
    }

    @Override
    public Map<String, Selection> getDefinitionToSelectionMap() {
        return null;
    }

    @Override
    public Map<String, Set<Selection>> getReferenceToSelectionsMap() {
        return null;
    }

    @Override
    public boolean isLinkNavigable(String uniqueStr) {
        return false;
    }

    @Override
    public String getLinkDescription(String uniqueStr) {
        return null;
    }
}
