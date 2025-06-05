package Dados;
import java.util.Date;

public class DocumentoAluno {
    private final int documentoID;
    private String tipo;
    private String caminhoArquivo;
    private final Date dataUpload;

    public DocumentoAluno(int documentoID, String tipo, String caminhoArquvio, Date dataUpload) {
        this.documentoID = documentoID;
        this.tipo = tipo;
        this.caminhoArquivo = caminhoArquvio;
        this.dataUpload = dataUpload;
    }

    public int getDocumentoID() {
        return documentoID;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCaminhoArquivo() {
        return caminhoArquivo;
    }

    public void setCaminhoArquivo(String caminhoArquivo) {
        this.caminhoArquivo = caminhoArquivo;
    }

    public Date getDataUpload() {
        return dataUpload;
    }
}



