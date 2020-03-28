package com.ming.sparearray;


import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * @ClassName com.ming.sparearray
 * @Author 24206
 * @Date 2020/3/27 15:30
 **/
public class ProxyDemo {
    public static void main(String[] args) {
        MaoTai maoTai = new MaoTai();
        WuLy wuLy = new WuLy();
        ZhiZhao o = (ZhiZhao)Proxy.newProxyInstance(MaoTai.class.getClassLoader(), MaoTai.class.getInterfaces(),(p,d,a) ->{
            System.out.println("大哥你真帅");
            d.invoke(wuLy,a);
            System.out.println("哦买噶");
            return null;
        } );
        o.sing();

    }
}



interface ZhiZhao{
    void maijiu();
    void sing();
}

class MaoTai implements ZhiZhao{
    @Override
    public void maijiu() {
        System.out.println("10万的茅台");
    }

    @Override
    public void sing() {

    }
}

class WuLy implements ZhiZhao{
    @Override
    public void maijiu() {
        System.out.println("8万的五粮液");
    }

    @Override
    public void sing() {
        System.out.println("起风了");
    }

}

class Mai implements InvocationHandler{

    Object p;
    Mai(Object o){
        this.p =o;
    }
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

        System.out.println("太便宜了，不卖");
        method.invoke(p,args);
        System.out.println("看你可怜给你了");
        return null;
    }
}
