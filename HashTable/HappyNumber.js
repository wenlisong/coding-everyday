// /**
//  * @param {number} n
//  * @return {boolean}
//  */
var isHappy = function (n) {
  let seen = {};
  while (n !== 1 && !seen[n]) {
    seen[n] = true
    n = n.toString().split('').reduce(
      (sum, num) => {
        return sum + Math.pow(num, 2);
      }, 0);
  };
  return n === 1 ? true : false
};