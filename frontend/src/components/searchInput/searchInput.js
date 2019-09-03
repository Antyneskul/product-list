import React from 'react';
import styles from './searchInput.module.css';

const SearchInput = ({onSearch}) => {
    const searchInput = React.createRef();

    const onSearchHandler = evt => {
        evt.preventDefault();
        onSearch(searchInput.current.value);
    };

    return (
        <form onSubmit={onSearchHandler} className={styles.searchForm}>
            <input
                className={styles.searchInput}
                ref={searchInput}
                placeholder={'Please Enter Item to Search...'}/>
            <button className={'btn btn-primary'}>Search</button>
        </form>
    )
};

export default SearchInput;
