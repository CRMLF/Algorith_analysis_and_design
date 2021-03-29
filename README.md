# Algorith_analysis_and_design
算法分析与设计主要代码

## 6 分治策略

### 6.1 二分查找

#### 6.1.1 问题

​	在一个排序好的数组T[1···n]中查找x，如果x在T中，输出x在T中的下标j；如果x不在T中，输出j=0

#### 6.1.2 解析

<img src="D:\文件夹\文档\Tencent Files\2869083541\FileRecv\MobileFile\IMG_20210329_133627.jpg" alt="解析" style="zoom: 10%;" />

#### 6.1.3 设计

```c
int BinarySearch(int T[], int x){
    int l = 1,r = n;
    while(l <= r){
    	int m = floor((l + r) / 2);
        if(T[m] == x) return m;
        else if(T[m] > x) r = m - 1;
        else l = m + 1;
    }
    return 0;
}
```

#### 6.1.4 分析

$$
\begin{cases}
\omega(n) = \omega(\lfloor{n\over 2}\rfloor)+1\\
\omega(1) = 1
\end{cases}
$$

$$
解：不妨设n = 2^k
$$
$$
(1) \omega(n) = \omega([{n \over 2}])+1
$$



