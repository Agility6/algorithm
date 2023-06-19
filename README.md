## Algorithms

### Introduce

- 🧮 Record the learning algorithms
- 📮 Document some commonly used algorithms

### 🦄 BASIC_ALGORITHMS

- [x] quick_sort
- [x] merge_sort
- [x] integer dichotomy
- [x] floating point dichotomy
- [x] one-dimensional prefixes sum

  ```tex
  S[i] = a[1] + a[2] + ... a[i]
  a[l] + ... + a[r] = S[r] - S[l - 1]
  ```
  
- [x] two-dimensional prefixes sum
  
  ```tex
  给以(x1, y1)为左上角，(x2, y2)为右下角的子矩阵中的所有元素加上c：
  S[x1, y1] += c, S[x2 + 1, y1] -= c, S[x1, y2 + 1] -= c, S[x2 + 1, y2 + 1] += c
  ```

- [ ] one-dimensional differential
- [ ] two-dimensional differential
- [ ] bit operations
- [ ] double pointer algorithms
- [ ] discretization
- [ ] interval merging
