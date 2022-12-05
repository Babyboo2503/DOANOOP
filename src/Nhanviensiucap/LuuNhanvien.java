package Nhanviensiucap;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * LuuNhanvien class
 *
 * @author Nhanviensiucap
 */
public class LuuNhanvien {
    private static final String NHANVIEN_FILE_NAME = "nhanvien.txt";

    /**
     * save list nhanvien to file
     *
     * @param nhanvienList: list nhanvien to save
     */
    public void write(List<Nhanvien> nhanvienList) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(new File(NHANVIEN_FILE_NAME));
            oos = new ObjectOutputStream(fos);
            oos.writeObject(nhanvienList);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            closeStream(fos);
            closeStream(oos);
        }
    }

    /**
     * read list nhanvien from file
     *
     * @return list nhanvien
     */
    public List<Nhanvien> read() {
        List<Nhanvien> nhanvienList = new ArrayList<>();
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(new File(NHANVIEN_FILE_NAME));
            ois = new ObjectInputStream(fis);
            nhanvienList = (List<Nhanvien>) ois.readObject();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            closeStream(fis);
            closeStream(ois);
        }
        return nhanvienList;
    }

    /**
     * close input stream
     *
     * @param is: input stream
     */
    private void closeStream(InputStream is) {
        if (is != null) {
            try {
                is.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * close output stream
     *
     * @param os: output stream
     */
    private void closeStream(OutputStream os) {
        if (os != null) {
            try {
                os.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}