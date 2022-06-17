// Importing CSS applies it to this component and any child components of it
import './CSSComponent.css';

export const CSSComponent = () => {
    return (
        <>
            {/* Inline styling. Multi word properites are camel case in JS */}
            <div className="center">
                <div id="box" style={{backgroundColor: 'red', height: '50px', width: '50px'}}></div>
            </div>
            
        </>
    );
}