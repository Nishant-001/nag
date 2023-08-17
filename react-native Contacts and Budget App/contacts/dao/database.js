import SQLite from 'react-native-sqlite-storage';

const db = SQLite.openDatabase({ name: 'contacts.db', location: 'default' });

db.transaction((tx) => {
  tx.executeSql(
    `CREATE TABLE IF NOT EXISTS contact (
      id INTEGER PRIMARY KEY AUTOINCREMENT,
      name TEXT,
      mobile TEXT,
      landline TEXT,
      photo TEXT,
      favorite INTEGER
    )`
  );
});

const saveContact = (name, mobile, landline, photo, favorite, callback) => {
  db.transaction((tx) => {
    tx.executeSql(
      `INSERT INTO contact (name, mobile, landline, photo, favorite) VALUES (?, ?, ?, ?, ?)`,
      [name, mobile, landline, photo, favorite ? 1 : 0],
      (_, result) => {
        console.log('Contact saved successfully!');
        if (callback) {
          callback();
        }
      },
      (_, error) => {
        console.error('Error saving contact:', error);
        console.log(favorite);
      }
    );
  });
};

const updateContact = (id, name, mobile, landline, photo, favorite, callback) => {
  db.transaction((tx) => {
    tx.executeSql(
      `UPDATE contact SET name=?, mobile=?, landline=?, photo=?, favorite=? WHERE id=?`,
      [name, mobile, landline, photo, favorite ? 1 : 0, id],
      (_, result) => {
        console.log('Contact updated successfully!');
        if (callback) {
          callback();
        }
      },
      (_, error) => {
        console.error('Error updating contact:', error);
      }
    );
  });
};

const deleteContact = (id, callback) => {
  db.transaction((tx) => {
    tx.executeSql(
      `DELETE FROM contact WHERE id=?`,
      [id],
      (_, result) => {
        console.log('Contact deleted successfully!');
        if (callback) {
          callback();
        }
      },
      (_, error) => {
        console.error('Error deleting contact:', error);
      }
    );
  });
};

const getAllContacts = (callback) => {
  db.transaction((tx) => {
    tx.executeSql(
      `SELECT * FROM contact`,
      [],
      (_, { rows }) => {
        const contacts = rows.raw();
        callback(contacts);
      },
      (_, error) => {
        console.error('Error retrieving contacts:', error);
        callback([]);
      }
    );
  });
};

const getfavContacts = (callback) => {
  db.transaction((tx) => {
    tx.executeSql(
      `SELECT * FROM contact WHERE favorite=1`,
      [],
      (_, { rows }) => {
        const contacts = rows.raw();
        callback(contacts);
      },
      (_, error) => {
        console.error('Error retrieving favorite contacts:', error);
        callback([]);
      }
    );
  });
}

const searchContacts = (searchQuery, callback) => {
  db.transaction((tx) => {
    tx.executeSql(
      `SELECT * FROM contact WHERE name LIKE ?`,
      [`%${searchQuery}%`],
      (_, { rows }) => {
        const contacts = rows.raw();
        callback(contacts);
      },
      (_, error) => {
        console.error('Error searching contacts:', error);
        callback([]);
      }
    );
  });
};

export { saveContact, updateContact, deleteContact, getAllContacts, searchContacts,getfavContacts };
