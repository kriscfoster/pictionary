const fs = require('fs');
const arr = fs.readFileSync('words.txt').toString().split('\n');
const duplicates = arr.filter((item, index) => arr.indexOf(item) != index)

console.log(`${arr.length} words\n${duplicates.length} duplicate words: [${duplicates}]`);


let string = '';

arr.forEach((word) => {
  string += `INSERT INTO word (name) VALUES ('${word}');\n`
})

fs.writeFileSync('./src/main/resources/data.sql', string);