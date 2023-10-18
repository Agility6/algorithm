### 🦄 BASIC_ALGORITHMS

- [x] quick_sort
- [x] merge_sort
- [x] integer dichotomy
- [x] floating point dichotomy
- [x] one-dimensional prefixes sum
  
  <details>
  <summary>Code</summary>
    
    ```tex
    
      S[i] = a[1] + a[2] + ... a[i]
      a[l] + ... + a[r] = S[r] - S[l - 1]
    
    ``` 
  
  </details>  
- [x] two-dimensional prefixes sum
  
  <details>
  <summary>Code</summary>
    
    ```tex
    
      S[i, j] = 第i行j列格子左上部分所有元素的和
      以(x1, y1)为左上角，(x2, y2)为右下角的子矩阵的和为：
      S[x2, y2] - S[x1 - 1, y2] - S[x2, y1 - 1] + S[x1 - 1, y1 - 1]
      
    ```
    
  </details> 

- [x] one-dimensional differential

  <details>
  <summary>Code</summary>
    
     ```tex
     
      给区间[l, r]只每个数加上c: b[l] += c, b[r + 1] -= c
      满足以下规律
      a[i] = b[1] + b[2] + b[3] + ... + b[i]
      当b[l] += c 意味着求 a[l]的时候 --> a[l] = b[1] + b[2] + ... + b[l] + c
      那么 a[l + 1] = a[l] + b[l + 1] + c 也会+C 依次类推
      所以当我们 b[l] += c 执行这句时，后面的都会+c
      但是求的是[l, r]区域+c，所以将r+1后面的-c
     
     ```
     
  </details> 

- [x] two-dimensional differential

  <details>
  <summary>Code</summary>
    
    ```tex
    
      给以(x1, y1)为左上角，(x2, y2)为右下角的子矩阵中的所有元素加上c：

      总体思路和一维的差不多
      1. 先构造b数组
        b[x1, y1] += c
        b[x2 + 1, y1] -= c
        b[x1, y2 + 1] -= c
        [x2 + 1, y2 + 1] += c
      
      2. 对b数组求前缀和
        b[i][j] = b[x - 1][j] + b[x][j - 1] - b[i - 1][j - 1] + b[i][j]
    
    ```
    
  </details>  

    
- [ ] bit operations
- [x] double pointer algorithms
- [x] discretization
- [x] interval merging

### 🦄 BASIC_ALGORITHMS 

- [ ] Single Linked List
- [ ] Doubly Linked List 
- [ ] Stack
- [ ] Queue
- [ ] Monotone Stack
- [ ] Monotonic Queue
- [x] KMP
  
  <details>
  <summary>Code</summary>
    
    ```java
    
      /** s[]是长文本，p[]是模式串，n是s的长度，m是p的长度 */
      /** 求模式串的Next数组 */
      for (int i = 2, j = 0; j <= m; i++) {

        while (j > 0 && p[i] != p[j + 1]) j = ne[j];

        if (p[i] == p[j + 1]) j++;

        ne[i] = j;
      }

      /** 匹配 */
      for (int i = 1, j = 0; i <= n; i++) {

        while (j > 0 && s[i] != p[j + 1]) j = ne[j];

        if (s[i] == p[j + 1]) j++;
        
        if (j == m) {
          j = ne[j];
          // 匹配成功
        }
      }
    
    ```
    
  </details>  
   

- [x] Trie

  <details>
  <summary>Code</summary>
    
    ```java
    
    // 存储树中每个节点的子节点
    int[][] son = new int[N][26];
    // 存储以节点为结尾的单词个数
    int[] cnt = new int[N];
    // 标记下标
    int index = 0;

    // 插入操作
    public void insert(String str) {

      int p = 0;

      for (int i = 0; i < str.length(); i++) {
        
        // 如果不存在该字符则添加，u：自己定义的含义
        if (son[p][u] == 0) son[p][u] = ++index;
        // 存在则继续
        p = son[p][u];
      }

      cnt[p]++;
    }

    // 查询字符串出现的次数
    public int query(String str) {
      
      int p = 0;

      for (int i = 0; i < str.length(); i++) {

        // 不存在该字符则该字符串没有
        if (son[p][u] == 0) return 0;
        p = son[p][u];

      }

      return cnt[p];
    }
    
  ```
    
  </details> 

- [x] Disjoint-set data structure

  <details>
  <summary>Code</summary>
    朴素并查集
    
      ```java
      
        int[] p = new int[N]; // 存储每个节点的祖宗节点

        // 返回祖宗节点 + 路径压缩
        public int find(int x) {

          if (p[x] != x) p[x] = find(p[x]);
          return p[x];
          
        }

        // 初始化 节点编号1~n
        for (int i = 1; i <= n; i++) p[i] = i;

        // 合并a和b集合(a向b合并，a集合的根节点等于b集合的根节点)
        p[find(a)] = find(b);
      
      ```

    维护size的并查集

      ```java
      
        int[] p = new int[N];
        // 记录祖宗节点所在集合中的数量
        int[] size = new int[N];

        public int find(int x) {
          if (p[x] != x) p[x] = find(p[x]);
          return p[x];
        }

        // 初始化
        for (int i = 1; i <= n; i++) {
          p[i] = i;
          size[i] = 1;
        }

        // 合并两个集合(有顺序要求)
        // 将a集合合并到b集合中，将a的size加到a
        size[find(b)] += size[find(a)];
        p[find[a]] = find(b); 
      ```

    维护到祖宗节点的距离的并查集

      ```java
      
        int[] p = new int[N];
        int[] d = new int[N]; // x到p[x]的距离

        public int find(int x) {

          if (p[x] != x) {
            int u = find(p[x]);
            d[x] += d[p[x]]; // 当前节点的值加当前节点的父元素的值
            p[x] = u;
          }

            return p[x];
          }

        for (int = 1; i <= n; i++) {
          p[i] = i;
          d[i] = 0;
        }

        // 合并
        p[find(a)] = find(b);
        d[find(a)] = distance; // 具体问题
      
      ```

  </details> 


- [ ] Heap
- [ ] Hash table
