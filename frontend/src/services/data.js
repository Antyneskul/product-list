const getData = async (searchQuery = '', page = 1, pageSize = 25) => await window
    .fetch(`http://0.0.0.0:8080/products?search=${searchQuery}&page=${page}&pageSize=${pageSize}`)
    .then(response => {
        if (response.ok) {
            return response.json()

        } else {
            throw new Error('Server Error');
        }
    })
    .catch(error => {
        throw new Error(error.message);
    });

export { getData }
