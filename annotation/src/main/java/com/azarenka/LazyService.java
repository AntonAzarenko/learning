package com.azarenka;

@Service(name = "superLazy",lazyLoad = true)
public class LazyService {

    @Init
    public void lazyInit() throws Exception{
        System.out.println("lazyInit exec");
    }

    public void print(){
        System.out.println("lazy class");
    }
}
