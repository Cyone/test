package wangTiling;

@FunctionalInterface
public interface Action1Param<T>
{
    void invoke(T t);
}