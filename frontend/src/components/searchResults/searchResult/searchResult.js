import React from 'react';
import styles from './searchResult.module.css';


const SearchResult = ({result = {}}) => <div key={result.id} className={styles.searchResult}>
    <h4>{result.title}</h4>
    <div className={styles.imageWrapper}>
        <img src={result.imageUrl} alt={result.title}/>
    </div>
    <div className={styles.details}>
        <div>Price: <b>{result.price}</b></div>
        <div>Rating: <b>{result.rating}</b></div>
    </div>

</div>;

export default SearchResult;
