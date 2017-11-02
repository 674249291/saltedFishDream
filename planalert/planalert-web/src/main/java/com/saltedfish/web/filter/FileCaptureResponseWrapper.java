package com.saltedfish.web.filter;

import java.io.CharArrayWriter;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class FileCaptureResponseWrapper extends HttpServletResponseWrapper {

    private CharArrayWriter output;

    private HttpServletResponse response;

    @Override
    public String toString() {
        return output.toString();
    }
    public FileCaptureResponseWrapper(HttpServletResponse response) {
        super(response);
        this.response=response;
        output =new CharArrayWriter();
    }
    //覆写getWriter()
    @Override
    public PrintWriter getWriter() {
        return new PrintWriter(output);
    }

    public void writeFile(String fileName)throws IOException {
        FileOutputStream fos=new FileOutputStream(fileName);
        OutputStreamWriter osw=new OutputStreamWriter(fos,"UTF-8");
        osw.write(output.toCharArray());
        osw.close();
    }

    public void writeResponse() throws IOException {
        PrintWriter out = response.getWriter();
        // 重置响应输出的内容长度
        response.setContentLength(-1);
        out.print( output.toCharArray() );
        out.flush();
        out.close();
    }

}
