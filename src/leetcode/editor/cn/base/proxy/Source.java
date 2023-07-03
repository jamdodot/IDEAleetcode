package leetcode.editor.cn.base.proxy;

/**
 * Created with IntelliJ IDEA.
 *
 * @Author: sunshine
 * @Date: 2023/05/14/20:36
 * @Description:
 */
public class Source implements Sourceable{
    @Override
    public void method() {
        System.out.println("methodSource");
    }
}
