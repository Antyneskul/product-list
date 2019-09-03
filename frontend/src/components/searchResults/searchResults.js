import React from 'react';
import SearchResult from './searchResult/searchResult';
import styles from './searchResults.module.css';


const SearchResults = ({results = []}) => (
    <div className={styles.searchResults}>
        {results.map((el, i) => <SearchResult result={el} key={`${i + el.id}`}/>)}
    </div>
);

export default SearchResults;
