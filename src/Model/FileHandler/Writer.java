package Model.FileHandler;

import java.io.Serializable;

public interface Writer {
    boolean write(Serializable serializable);

    Object read();

    void setFilePath(String filePath);
}
